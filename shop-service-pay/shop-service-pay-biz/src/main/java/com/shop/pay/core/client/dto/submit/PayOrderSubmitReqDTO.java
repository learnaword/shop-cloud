package com.shop.pay.core.client.dto.submit;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayOrderSubmitReqDTO {

    private String NotifyUrl;

    private String returnUrl;

    private String outTradeNo;

    private BigDecimal totalAmount;

   private String subject;

}
