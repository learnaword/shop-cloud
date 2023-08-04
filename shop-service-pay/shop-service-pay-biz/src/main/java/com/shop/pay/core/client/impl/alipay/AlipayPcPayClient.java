package com.shop.pay.core.client.impl.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.shop.pay.core.client.alipay.AlipayPayClientConfig;
import com.shop.pay.core.client.dto.refund.PayOrderRefundReqDTO;
import com.shop.pay.core.client.dto.submit.PayOrderSubmitReqDTO;
import com.shop.pay.core.enums.PayConfigEnum;

public class AlipayPcPayClient extends AbstractAlipyPayClient {

    public AlipayPcPayClient(Long appId, AlipayPayClientConfig payConfig) {
        super(PayConfigEnum.ALIPAY_PC.getCode(), appId, payConfig);
    }

    /*
     * 提供具体的服务调用逻辑
     */
    @Override
    protected String doSubmitOrder(PayOrderSubmitReqDTO reqDTO) throws AlipayApiException {

        //官方示例代码
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(reqDTO.getNotifyUrl());
        request.setReturnUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", reqDTO.getOutTradeNo());
        bizContent.put("total_amount", reqDTO.getTotalAmount());
        bizContent.put("subject", "测试商品");

        bizContent.put("qr_pay_mode",2);

        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        //bizContent.put("time_expire", "2022-08-01 22:00:00");

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = client.pageExecute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");

        }
        System.out.println(response.getBody());
        return response.getBody();
    }

    @Override
    protected void doRefundOrder(PayOrderRefundReqDTO reqDTO) {

    }

    protected String formatAmount(Integer amount) {
        return String.valueOf(amount / 100.0);
    }
}
