package com.shop.pay.controller.config.vo;

import lombok.Data;

@Data
public class CreatePayConfigReqVO {

    /**
     * 支付类型
     */
    private String code;

    /**
     * 是否开启
     */
    private Integer status;

    /**
     * 与pay_app进行关联
     */
    private Long payAppid;

    /**
     * 描述
     */
    private String remark;

    /**
     * 配置数据，json字符串
     *
     * 为什么是json呢
     */
    private String config;
}
