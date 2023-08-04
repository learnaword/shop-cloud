package com.shop.pay.service.impl;

import com.shop.order.OrderApi;
import com.shop.order.dto.OrderRespDTO;
import com.shop.pay.controller.pay.VO.PayOrderRefundReqVO;
import com.shop.pay.core.client.PayClientFactory;
import com.shop.pay.core.client.dto.refund.PayOrderRefundReqDTO;
import com.shop.pay.core.client.dto.submit.PayOrderSubmitReqDTO;
import com.shop.pay.service.PayService;
import com.shop.pay.controller.pay.VO.PayOrderSubmitReqVO;
import com.shop.pay.core.client.PayClient;
import com.shop.pay.dal.dataobject.PayAppDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    PayClientFactory payClientFactory;
    @Resource
    PayAppServiceImpl payAppService;
    @Resource
    OrderApi orderApi;


    @Override
    public String submitOrder(PayOrderSubmitReqVO payOrderSubmitReqVO){

        Long appId = 1L;
        String code = "alipay_pc";

        //获取到具体的client
        PayClient payClient = payClientFactory.getClient(appId,code);

        //获取PayApp
        PayAppDO payAppDO = payAppService.getPayAppById(payOrderSubmitReqVO.getPayAppid());
        //获取订单信息
        OrderRespDTO orderRespDTO = orderApi.getOrderById(payOrderSubmitReqVO.getOrderId());

        PayOrderSubmitReqDTO payOrderSubmitReqDTO = new PayOrderSubmitReqDTO()
                .setNotifyUrl(payAppDO.getNotifyUrl())
                .setSubject(orderRespDTO.getSubject())
                .setTotalAmount(orderRespDTO.getTotalAmount())
                .setOutTradeNo(orderRespDTO.getOrderNo());
        //提交订单
        return payClient.submitOrder(payOrderSubmitReqDTO);
    }

    @Override
    public void refundOrder(PayOrderRefundReqVO payOrderRefundReqVo) {

        Long appId = 1L;
        String code = "alipay_pc";
        //获取到具体的client
        PayClient payClient = payClientFactory.getClient(appId,code);

        PayOrderRefundReqDTO payOrderRefundReqDTO = new PayOrderRefundReqDTO();
        //订单退款
        payClient.refundOrder(payOrderRefundReqDTO);

    }
}
