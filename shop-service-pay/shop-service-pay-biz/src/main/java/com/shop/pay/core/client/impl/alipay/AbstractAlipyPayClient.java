package com.shop.pay.core.client.impl.alipay;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.shop.pay.core.client.alipay.AlipayPayClientConfig;
import com.shop.pay.core.client.impl.AbstractPayClient;
import lombok.SneakyThrows;

public abstract class AbstractAlipyPayClient extends AbstractPayClient {

    protected DefaultAlipayClient client;

    public AbstractAlipyPayClient(String code,Long appId, AlipayPayClientConfig payClientConfig){
        super(code,appId,payClientConfig);

        //初始化client
        init();
    }

    @SneakyThrows
    protected void init(){
        AlipayConfig alipayConfig = new AlipayConfig();
        BeanUtil.copyProperties(payClientConfig, alipayConfig, false);
        this.client = new DefaultAlipayClient(alipayConfig);
    }

}
