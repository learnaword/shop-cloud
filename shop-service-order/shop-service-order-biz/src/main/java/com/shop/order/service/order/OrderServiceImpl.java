package com.shop.order.service.order;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shop.common.enums.CommonStatusEnum;
import com.shop.common.utils.DateUtils;
import com.shop.common.utils.JsonUtils;
import com.shop.order.dal.dataobject.ProductDO;
import com.shop.order.enums.OrderStatusEnum;
import com.shop.order.service.order.bo.OrderInfoDetailBO;
import com.shop.order.service.product.ProductService;
import com.shop.order.service.user.UserServiceImpl;
import com.shop.order.controller.VO.*;
import com.shop.order.dal.dataobject.OrderDO;
import com.shop.order.dal.mapper.OrderMapper;
import com.shop.order.service.order.bo.OrderInfoBO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.shop.common.exception.util.ServiceExceptionUtil.exception;
import static com.shop.enums.ErrorCodeConstants.*;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Resource
    UserServiceImpl userService;

    @Resource
    ProductService productService;

    @Resource
    OrderMapper orderMapper;

    private final StringRedisTemplate redisTemplate;


    @Override
    public PreOrderRespVO preOrder(PreOrderReqVO preOrderReqVO) {

        //计算商品的价格
        BigDecimal totalPrice;
        //对订单信息进行检验
        OrderInfoBO orderInfoBO = validatePreOrderRequest(preOrderReqVO);
        totalPrice = orderInfoBO.getOrderDetailList().stream().map(e -> e.getPrice().multiply(new BigDecimal(e.getPayNum()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        orderInfoBO.setProTotalFee(totalPrice);
        // 购买商品总数量
        int orderProNum = orderInfoBO.getOrderDetailList().stream().mapToInt(OrderInfoDetailBO::getPayNum).sum();

        orderInfoBO.setOrderProNum(orderProNum);

        // 实际支付金额
        orderInfoBO.setPayFee(orderInfoBO.getProTotalFee());

        // 缓存订单
        String key = DateUtils.getNowTime()+ IdUtil.fastSimpleUUID();

        redisTemplate.opsForValue().set("user_order:" + key, JsonUtils.toJsonString(orderInfoBO), 60, TimeUnit.MINUTES);

        PreOrderRespVO preOrderResqVO = new PreOrderRespVO();
        preOrderResqVO.setPreOrderNo(key);

        return preOrderResqVO;
    }

    @Override
    public OrderCreateRespVO orderCreate(OrderCreateReqVO orderCreateReqVO) {

        //检查预订单信息，并将预订单信息转换为orderInfoBO
        String key = "user_order:" + orderCreateReqVO.getPreOrderNo();
        if(redisTemplate.hasKey(key)){
            throw exception(PRE_ORDER_NOT_FOUND);
        }
        String orderInfoStr = redisTemplate.opsForValue().get(key);
        OrderInfoBO orderInfo = JsonUtils.parseObject(orderInfoStr, OrderInfoBO.class);

        OrderDO orderDO = new OrderDO();

        String orderId = IdUtil.fastSimpleUUID();

        orderDO.setOrderNo(orderId);
        orderDO.setRemark(orderCreateReqVO.getRemark());
        orderDO.setPayType(orderCreateReqVO.getCode());

        //这里只做立即购买，所以订单详情里只有一个商品
        OrderInfoDetailBO orderInfoDetailBO=  orderInfo.getOrderDetailList().get(0);

        orderDO.setSubject(orderInfoDetailBO.getProductName());
        orderDO.setTotalAmount(orderInfo.getPayFee());
        orderDO.setStatus(OrderStatusEnum.NO.getStatus());
        orderDO.setIsDel(CommonStatusEnum.ENABLE.getStatus());
        orderDO.setProductId(orderInfoDetailBO.getProductId());
        orderDO.setUpdateTime(LocalDateTime.now());
        orderDO.setCreateTime(LocalDateTime.now());

        orderMapper.insert(orderDO);
        //删除预订单信息
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }

        OrderCreateRespVO orderCreateRespVO = new OrderCreateRespVO();
        orderCreateRespVO.setOrderId(orderDO.getId());

        //将订单编号加入到自动取消订单列表里，之后会写这部分逻辑自动取消任务。
        redisTemplate.opsForList().leftPop("auto_cancel_order",orderDO.getId());

        return orderCreateRespVO;
    }

    @Override
    public OrderDO getOrderById(Long id) {
        return orderMapper.selectById(id);
    }

    private OrderInfoBO validatePreOrderRequest(PreOrderReqVO preOrderReqVO) {
        OrderInfoBO orderInfoVo = new OrderInfoBO();

        List<OrderInfoDetailBO> detailVoList = CollUtil.newArrayList();

        //普通商品立即购买
        if("buyNow".equals(preOrderReqVO.getPreOrderType())){
            PreOrderDetailVO detail = preOrderReqVO.getOrderDetails().get(0);

            if (ObjectUtil.isNull(detail.getProductId())) {
                throw exception(PRODUCT_ID_NOT_NULL);
            }
            if (ObjectUtil.isNull(detail.getProductNum()) || detail.getProductNum() < 0) {
                throw exception(PRODUCT_NUM_IS_ZERO);
            }

            ProductDO product = productService.getById(detail.getProductId());

            if (ObjectUtil.isNull(product)) {
                throw exception(PRODUCT_NUM_IS_ZERO);
            }

            if (product.getIsDel()) {
                throw exception(PRODUCT_NOT_FOUND);
            }

            if (!product.getIsShow()) {
                throw exception(PRODUCT_OFF_SALE);
            }

            if (product.getStock() < detail.getProductNum()) {
                throw exception(PRODUCT_OUT_OF_STOCK);
            }

            OrderInfoDetailBO detailBO = new OrderInfoDetailBO();
            detailBO.setProductId(product.getId());
            detailBO.setProductName(product.getName());
            detailBO.setPayNum(detail.getProductNum());
            detailBO.setProductType(0);
            detailBO.setPrice(product.getPrice());
            detailVoList.add(detailBO);

        }
        orderInfoVo.setOrderDetailList(detailVoList);
        return orderInfoVo;
    }
}
