package com.shop.pay.core.enums;

import cn.hutool.core.util.ArrayUtil;
import com.shop.pay.core.client.PayClientConfig;
import com.shop.pay.core.client.alipay.AlipayPayClientConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付渠道的编码的枚举
 *
 */
@Getter
@AllArgsConstructor
public enum PayConfigEnum {

    ALIPAY_PC("alipay_pc", "支付宝 PC 网站支付", AlipayPayClientConfig.class),
    ALIPAY_WAP("alipay_wap", "支付宝 wap 支付", AlipayPayClientConfig.class),
    ALIPAY_APP("alipay_app", "支付宝 APP 支付", AlipayPayClientConfig.class);

    /**
     * 编码
     *
     * 参考 <a href="https://www.pingxx.com/api/支付渠道属性值.html">支付渠道属性值</a>
     */
    private final String code;
    /**
     * 名字
     */
    private final String name;

    /**
     * 配置类
     */
    private final Class<? extends PayClientConfig> configClass;

    /**
     * 微信支付
     */
    public static final String WECHAT = "WECHAT";

    /**
     * 支付宝支付
     */
    public static final String ALIPAY = "ALIPAY";

    public static PayConfigEnum getByCode(String code) {
        return ArrayUtil.firstMatch(o -> o.getCode().equals(code), values());
    }

}
