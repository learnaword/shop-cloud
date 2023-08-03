package com.shop.pay.service;

import com.alipay.api.AlipayApiException;
import com.shop.pay.controller.pay.VO.PayOrderRefundReqVO;
import com.shop.pay.controller.pay.VO.PayOrderSubmitReqVO;

public interface PayService {
    String submitOrder(PayOrderSubmitReqVO payOrderSubmitReqVo) throws AlipayApiException;
    void refundOrder(PayOrderRefundReqVO payOrderRefundReqVo);

}
