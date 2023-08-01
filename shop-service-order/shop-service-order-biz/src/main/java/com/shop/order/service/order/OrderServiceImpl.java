package com.shop.order.service.order;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shop.order.controller.VO.PreOrderDetailVO;
import com.shop.order.controller.VO.PreOrderReqVO;
import com.shop.order.controller.VO.PreOrderResqVO;
import com.shop.order.dal.dataobject.ProductDO;
import com.shop.order.dal.dataobject.User;
import com.shop.order.service.order.bo.OrderInfoBO;
import com.shop.order.service.order.bo.OrderInfoDetailBO;
import com.shop.order.service.product.ProductService;
import com.shop.order.service.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.shop.common.utils.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProductService productService;

    private final StringRedisTemplate redisTemplate;


    @Override
    public PreOrderResqVO preOrder(PreOrderReqVO preOrderReqVO) {

        //计算商品的价格
        BigDecimal totalPrice;
        User user = userService.getUserInfo();
        OrderInfoBO orderInfoBO = validatePreOrderRequest(preOrderReqVO);
        totalPrice = orderInfoBO.getOrderDetailList().stream().map(e -> e.getPrice().multiply(new BigDecimal(e.getPayNum()))).reduce(BigDecimal.ZERO, BigDecimal::add);
        orderInfoBO.setProTotalFee(totalPrice);
        // 购买商品总数量
        int orderProNum = orderInfoBO.getOrderDetailList().stream().mapToInt(OrderInfoDetailBO::getPayNum).sum();

        orderInfoBO.setOrderProNum(orderProNum);

        // 实际支付金额
        orderInfoBO.setPayFee(orderInfoBO.getProTotalFee());

        // 缓存订单
        String key = user.getUid() +DateUtils.getNowTime()+ IdUtil.fastSimpleUUID();

        redisTemplate.opsForValue().set("user_order:" + key, JsonUtils.toJsonString(orderInfoBO), 60, TimeUnit.MINUTES);

        PreOrderResqVO preOrderResqVO = new PreOrderResqVO();
        preOrderResqVO.setPreOrderNo(key);

        return preOrderResqVO;
    }

    private OrderInfoBO validatePreOrderRequest(PreOrderReqVO preOrderReqVO) {
        OrderInfoBO orderInfoVo = new OrderInfoBO();

        List<OrderInfoDetailBO> detailVoList = CollUtil.newArrayList();

        //普通商品立即购买
        if("buyNow".equals(preOrderReqVO.getPreOrderType())){
            PreOrderDetailVO detail = preOrderReqVO.getOrderDetails().get(0);

            if (ObjectUtil.isNull(detail.getProductId())) {
                System.out.println("商品编号不能为空");
            }
            if (ObjectUtil.isNull(detail.getProductNum()) || detail.getProductNum() < 0) {
                System.out.println("购买商品必须大于0");
            }

            ProductDO product = productService.getById(detail.getProductId());

            if (ObjectUtil.isNull(product)) {
                System.out.println("商品信息不存在，请刷新后重新选择");
            }
            if (product.getIsDel()) {
                System.out.println("商品已删除，请刷新后重新选择");
            }
            if (!product.getIsShow()) {
                System.out.println("商品已下架，请刷新后重新选择");
            }
            if (product.getStock() < detail.getProductNum()) {
                System.out.println("商品库存不足，请刷新后重新选择");
            }
            OrderInfoDetailBO detailBO = new OrderInfoDetailBO();
            detailBO.setProductId(product.getId());
            detailBO.setProductName(product.getName());
            detailBO.setPayNum(detail.getProductNum());
            detailBO.setProductType(0);

            detailVoList.add(detailBO);

        }
        orderInfoVo.setOrderDetailList(detailVoList);
        return orderInfoVo;
    }
}
