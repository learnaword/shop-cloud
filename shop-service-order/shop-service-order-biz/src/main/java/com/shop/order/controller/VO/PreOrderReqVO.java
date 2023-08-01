package com.shop.order.controller.VO;

import lombok.Data;

import java.util.List;

@Data
public class PreOrderReqVO {

    //下单类型
    private String preOrderType;

    //下单详情
    private List<PreOrderDetailVO> orderDetails;

}
