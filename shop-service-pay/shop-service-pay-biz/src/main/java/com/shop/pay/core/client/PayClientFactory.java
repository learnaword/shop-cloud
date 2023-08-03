package com.shop.pay.core.client;

/**
 * 支付宝抽象类，实现支付宝统一的接口、以及部分实现（退款）
 *
 */
public interface PayClientFactory {

    public PayClient getClient(Long appid,String code);
}
