package com.shop.order;

import org.springframework.cloud.openfeign.FallbackFactory;

public class OrderApiFallbackFactory implements FallbackFactory<OrderApiFallback> {

    @Override
    public OrderApiFallback create(Throwable cause) {
        return new OrderApiFallback(cause);
    }
}
