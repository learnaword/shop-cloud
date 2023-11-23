package com.shop.pay.config;

import com.shop.order.OrderApiFallbackFactory;
import com.shop.pay.core.client.PayClientFactory;
import com.shop.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayAutoConfig {

    @Bean
    public PayClientFactory PayClientFactory(){
        return new PayClientFactoryImpl();
    }
}
