package com.shop.order.controller;


import com.shop.common.pojo.CommonResult;
import com.shop.order.service.order.OrderService;
import com.shop.order.controller.VO.OrderCreateReqVO;
import com.shop.order.controller.VO.OrderCreateRespVO;
import com.shop.order.controller.VO.PreOrderReqVO;
import com.shop.order.controller.VO.PreOrderRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
