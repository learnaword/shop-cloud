package com.shop.pay.service;


import com.shop.pay.dal.dataobject.PayOrderDO;

public interface PayOrderService {
    public void createOrder();

    public void cancelOrder(Long orderId);

    public PayOrderDO getOrderById(Long orderId);

}
