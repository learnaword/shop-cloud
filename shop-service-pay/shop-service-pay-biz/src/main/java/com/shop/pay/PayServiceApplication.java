package com.shop.pay;

import com.shop.order.OrderApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients(clients=OrderApi.class)
public class PayServiceApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(PayServiceApplication.class, args);
    }
}
