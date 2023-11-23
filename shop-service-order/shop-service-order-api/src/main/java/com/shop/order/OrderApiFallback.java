package com.shop.order;

import com.shop.order.dto.OrderRespDTO;


public class OrderApiFallback implements OrderApi {

    private Throwable throwable;

    public OrderApiFallback(Throwable cause) {
        this.throwable = cause;
    }

    @Override
    public OrderRespDTO getOrderById(Integer id) {
        System.out.println("方法getOrderById执行降级");
        return null;
    }
}
