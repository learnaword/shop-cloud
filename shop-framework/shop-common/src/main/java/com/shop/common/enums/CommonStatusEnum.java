package com.shop.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付订单的通知状态枚举
 *
 */
@Getter
@AllArgsConstructor
public enum CommonStatusEnum {

    ENABLE(0, "开启"),
    DISABLE(1, "关闭");
    private final Integer status;
    private final String name;
}
