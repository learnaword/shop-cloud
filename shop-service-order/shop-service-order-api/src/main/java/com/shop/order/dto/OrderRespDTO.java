package com.shop.order.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderRespDTO {
    //订单id
    private int id;

    //商品标题
    private String subject;

    //订单号
    private String orderNo;

    //支付总金额
    private BigDecimal totalAmount;

    //商品id
    private int productId;

    //商品状态
    private Integer status;

    //订单创建时间
    private LocalDateTime createTime;

    //订单更新时间
    private LocalDateTime updateTime;

    //是否删除
    private Integer isDel;

    //支付方式
    private String payType;

    //备注
    private String remark;

    //支付时间
    private LocalDateTime payTime;
}
