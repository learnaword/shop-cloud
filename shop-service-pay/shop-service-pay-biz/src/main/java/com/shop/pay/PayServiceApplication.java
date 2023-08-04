package com.shop.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class PayServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PayServiceApplication.class, args);
    }
}
