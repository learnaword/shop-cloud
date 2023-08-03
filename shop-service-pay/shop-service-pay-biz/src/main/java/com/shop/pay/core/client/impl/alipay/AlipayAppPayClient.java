package com.shop.pay.core.client.impl.alipay;


import com.shop.pay.core.client.alipay.AlipayPayClientConfig;
import com.shop.pay.core.client.dto.refund.PayOrderRefundReqDTO;
import com.shop.pay.core.client.dto.submit.PayOrderSubmitReqDTO;
import com.shop.pay.core.enums.PayConfigEnum;

public class AlipayAppPayClient extends AbstractAlipyPayClient {

    public AlipayAppPayClient(Long appId, AlipayPayClientConfig payConfig) {
        super(PayConfigEnum.ALIPAY_APP.getCode(),appId,payConfig);
    }

    /*
    * 提供具体的服务调用逻辑
     */
    @Override
    protected String doSubmitOrder(PayOrderSubmitReqDTO reqDTO) {
        return "";
    }

    @Override
    protected void doRefundOrder(PayOrderRefundReqDTO reqDTO) {

    }
}
