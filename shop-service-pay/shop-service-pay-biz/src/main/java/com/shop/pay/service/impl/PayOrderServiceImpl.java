package com.shop.pay.service.impl;

import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.order.vo.PayOrderPageReqVO;
import com.shop.pay.dal.dataobject.PayOrderDO;
import com.shop.pay.dal.mysql.PayOrderMapper;
import com.shop.pay.enums.OrderStatusEnum;
import com.shop.pay.service.PayOrderService;
import com.shop.pay.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class PayOrderServiceImpl implements PayOrderService {

    @Resource
    private PayOrderMapper orderMapper;

    @Override
    public void createOrder() {
        PayOrderDO order = new PayOrderDO();
        order.setOrderNo(StringUtils.createOrderNum());
        order.setSubject("测试数据");
        order.setTotalAmount(1);
        order.setDescription("这是测试订单");
        order.setStatus(OrderStatusEnum.NO.getStatus());
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        orderMapper.insert(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        orderMapper.updateById(new PayOrderDO().setId(orderId).setStatus(OrderStatusEnum.CANCEL.getStatus()));
    }

    public PageResult<PayOrderDO> getOrderPage(PayOrderPageReqVO orderPageReqVO){
        return orderMapper.selectPage(orderPageReqVO);
    }

    public PayOrderDO getOrderById(Long orderId) {
        return orderMapper.selectOne(PayOrderDO::getId,orderId);
    }
}
