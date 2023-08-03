package com.shop.pay.controller.app.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString(callSuper = true)
public class PayAppPageRespVO {
    /**
     * 业务模块id
     */
    private Long id;

    /**
     * 业务昵称
     */
    private String name;

    /**
     * 回调地址
     */
    private String notifyUrl;

    /**
     * 退款通知
     */
    private String notifyRefundUrl;

    /**
     * 是否开启
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 对应的配置信息
     */
    private Set<String> configCodes;

}
