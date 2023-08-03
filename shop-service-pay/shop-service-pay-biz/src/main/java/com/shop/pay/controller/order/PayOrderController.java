package com.shop.pay.controller.order;

import com.shop.common.pojo.CommonResult;
import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.order.vo.PayOrderPageReqVO;
import com.shop.pay.controller.order.vo.PayOrderPageRespVO;
import com.shop.pay.convert.order.OrderConvert;
import com.shop.pay.dal.dataobject.PayOrderDO;
import com.shop.pay.service.impl.PayOrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.shop.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/order")
public class PayOrderController {

    @Resource
    private PayOrderServiceImpl payOrderService;

    @RequestMapping("/create")
    public CommonResult<Boolean> OrderCreate(){
        payOrderService.createOrder();
        return success(true);
    }

    @RequestMapping("/list")
    public CommonResult<PageResult<PayOrderPageRespVO>> getOrderPage(@Valid PayOrderPageReqVO orderPageReqVO){
        PageResult<PayOrderDO> pageResult = payOrderService.getOrderPage(orderPageReqVO);

        return success(OrderConvert.INSTANCE.convertPage(pageResult));
    }

    @RequestMapping("/get")
    public CommonResult<PayOrderDO> getOrder(@Valid Long orderId){
        PayOrderDO payOrder = payOrderService.getOrderById(orderId);

        return success(payOrder);
    }

    @RequestMapping("/cancel")
    public CommonResult<Boolean> cancelOrder(@Valid Long orderId){
        payOrderService.cancelOrder(orderId);
        return success(true);
    }
}
