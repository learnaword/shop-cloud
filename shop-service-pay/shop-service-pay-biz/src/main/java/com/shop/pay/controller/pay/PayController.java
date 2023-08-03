package com.shop.pay.controller.pay;

import com.shop.common.pojo.CommonResult;
import com.shop.pay.controller.pay.VO.PayOrderSubmitReqVO;
import com.shop.pay.service.impl.PayServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayServiceImpl payServiceimpl;

    @PostMapping("/submit")
    public CommonResult<String> submitOrder(PayOrderSubmitReqVO payOrderSubmitReqVO){
        return CommonResult.success(payServiceimpl.submitOrder(payOrderSubmitReqVO));
    }
}
