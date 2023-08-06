package com.shop.order.controller;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.shop.common.pojo.CommonResult;
import com.shop.framework.web.core.handler.GlobalExceptionHandler;
import com.shop.order.controller.VO.*;
import com.shop.order.service.order.OrderService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("/preOrder")
    public CommonResult<PreOrderRespVO> preOrder(@RequestBody PreOrderReqVO preOrderReqVO){
        return CommonResult.success(orderService.preOrder(preOrderReqVO));
    }

    @RequestMapping("/create")
    public CommonResult<OrderCreateRespVO> preOrder(@RequestBody OrderCreateReqVO orderCreateReqVO){
        return CommonResult.success(orderService.orderCreate(orderCreateReqVO));
    }
}
