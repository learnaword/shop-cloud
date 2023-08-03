package com.shop.order.controller.VO;

import com.sun.javaws.jnl.IconDesc;
import lombok.Data;

@Data
public class OrderCreateReqVO {

    //预下单订单号
    private String preOrderNo;

    //支付方式
    private String code;

    //备注
    private String remark;

}
