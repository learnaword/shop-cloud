package com.shop.pay.controller.pay;

import com.alipay.api.AlipayApiException;
import com.shop.common.pojo.CommonResult;
import com.shop.pay.controller.pay.VO.PayOrderSubmitReqVO;
import com.shop.pay.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/submit")
    public CommonResult<String> submitOrder(@RequestBody  PayOrderSubmitReqVO payOrderSubmitReqVO) throws AlipayApiException {
        return CommonResult.success(payService.submitOrder(payOrderSubmitReqVO));
    }
}
