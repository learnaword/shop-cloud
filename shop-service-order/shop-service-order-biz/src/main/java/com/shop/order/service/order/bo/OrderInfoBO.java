package com.shop.order.service.order.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfoBO {

    //商品总金额
    private BigDecimal proTotalFee;

    //订单商品数量
    private Integer orderProNum;

    //实际支付金额
    private BigDecimal payFee;

    //订单备注
    private String remark;

    //订单详情
    private List<OrderInfoDetailBO> orderDetailList;

    //购物车订单列表
    private List<Long> cartIdList;

    //商品总量
    private Integer payNum;
}
