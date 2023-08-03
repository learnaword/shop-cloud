package com.shop.pay.core.client.dto.submit;

import lombok.Data;

@Data
public class PayOrderSubmitReqDTO {

    private String NotifyUrl;

    private String returnUrl;

    private String outTradeNo;

    private Integer totalAmount;

   private String subject;

}
