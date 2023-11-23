package com.shop.config;

import com.shop.order.OrderApiFallbackFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class OrderApiAutoConfiguration {
    @Bean
    public OrderApiFallbackFactory orderApiFallbackFactory(){
        return new OrderApiFallbackFactory();
    }
}
