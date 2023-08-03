package com.shop.pay.controller.order.vo;

import com.shop.pay.enums.OrderStatusEnum;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
public class PayOrderPageRespVO {
    private Long id;

    //商品标题
    private String subject;

    //商品标题
    private Long payAppid;

    //订单编号
    private String orderNo;

    //订单金额
    private Integer totalAmount;

    //商品描述
    private String description;

    /**
     * 订单状态
     *
     * 枚举{@link OrderStatusEnum}
     */
    private Integer status;

    //下单时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDateTime updateTime;
}
