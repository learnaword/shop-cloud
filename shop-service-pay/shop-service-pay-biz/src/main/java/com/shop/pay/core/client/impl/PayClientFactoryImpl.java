package com.shop.pay.core.client.impl;

import com.shop.pay.core.client.PayClientFactory;
import com.shop.pay.core.client.alipay.AlipayPayClientConfig;
import com.shop.pay.core.enums.PayConfigEnum;
import com.shop.pay.dal.dataobject.PayConfigDO;
import com.shop.pay.service.PayConfigService;
import com.shop.pay.core.client.PayClient;
import com.shop.pay.core.client.impl.alipay.AlipayAppPayClient;
import com.shop.pay.core.client.impl.alipay.AlipayPcPayClient;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

@Slf4j
public class PayClientFactoryImpl implements PayClientFactory {

    @Resource
    PayConfigService payConfigService;

    /**
     * 根据appid和code返回具体的payClient
     * @param appid
     * @param code
     * @return
     */
    @Override
    public PayClient getClient(Long appId, String code) {

        PayConfigDO payConfigDO = payConfigService.getPayConfigByCodeAndpayAppid(code,appId);

        PayConfigEnum configEnum = PayConfigEnum.getByCode(code);

        switch(configEnum){
            case ALIPAY_PC: return new AlipayPcPayClient(appId, (AlipayPayClientConfig) payConfigDO.getConfig());
            case ALIPAY_APP: return new AlipayAppPayClient(appId, (AlipayPayClientConfig) payConfigDO.getConfig());
        }

        // 创建失败，错误日志 + 抛出异常
        log.error("[createPayClient][配置({}) 找不到合适的客户端实现]", code);
        throw new IllegalArgumentException(String.format("配置(%s) 找不到合适的客户端实现", code));
    }
}
