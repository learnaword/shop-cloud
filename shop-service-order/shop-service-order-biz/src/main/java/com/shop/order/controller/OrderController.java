package com.shop.order.controller;


import com.shop.common.pojo.CommonResult;
import com.shop.order.controller.VO.PreOrderReqVO;
import com.shop.order.controller.VO.PreOrderResqVO;
import com.shop.order.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/preOrder")
    public CommonResult<PreOrderResqVO> preOrder(@RequestBody PreOrderReqVO preOrderReqVO){
        return CommonResult.success(orderService.preOrder(preOrderReqVO));
    }
}
