package com.shop.pay.core.client;


import com.shop.pay.core.client.dto.refund.PayOrderRefundReqDTO;
import com.shop.pay.core.client.dto.refund.PayOrderRefundRespDTO;
import com.shop.pay.core.client.dto.submit.PayOrderSubmitReqDTO;

public interface PayClient {

    /**
     * 提交订单
     * @param reqDTO
     * @return
     */
    String submitOrder(PayOrderSubmitReqDTO reqDTO);

    /*
    *退款接口
     */
    PayOrderRefundRespDTO refundOrder(PayOrderRefundReqDTO reqDTO);


}
