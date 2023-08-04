package com.shop.pay.service.impl;

import com.shop.common.utils.JsonUtils;
import com.shop.pay.core.client.PayClientConfig;
import com.shop.pay.controller.config.vo.CreatePayConfigReqVO;
import com.shop.pay.controller.config.vo.UpdatePayConfigReqVO;
import com.shop.pay.convert.config.PayConfigConvert;
import com.shop.pay.core.enums.PayConfigEnum;
import com.shop.pay.dal.dataobject.PayConfigDO;
import com.shop.pay.dal.mapper.PayConfigMapper;
import com.shop.pay.service.PayConfigService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PayConfigServiceImpl implements PayConfigService {

    @Resource
    PayConfigMapper payConfigMapper;

    @Override
    public List<PayConfigDO> getAppConfigListByAppIds(Collection<Long> appIds) {
        return payConfigMapper.selectListByAppIds(appIds);
    }
    @Override
    public PayConfigDO getPayConfigByCodeAndpayAppid(String code,Long payAppid) {
        return payConfigMapper.selectOne(
                PayConfigDO::getCode,code,
                PayConfigDO::getPayAppid,payAppid
        );
    }
    @Override
    public PayConfigDO getPayConfig(Long id) {
        return payConfigMapper.selectById(id);
    }
    @Override
    public void updatePayConfig(UpdatePayConfigReqVO updatePayConfigReqVO) {

        PayConfigDO payConfigDO = PayConfigConvert.INSTANCE.convert(updatePayConfigReqVO);

        payConfigDO.setConfig(parseConfig(updatePayConfigReqVO.getCode(),updatePayConfigReqVO.getConfig()));

        payConfigMapper.updateById(payConfigDO);
    }


    private PayClientConfig parseConfig(String code, String configStr){
        // 解析配置
        Class<? extends PayClientConfig> payClass = PayConfigEnum.getByCode(code).getConfigClass();

        PayClientConfig config = JsonUtils.parseObject2(configStr, payClass);

        return config;
    }

    @Override
    public void createPayConfig(CreatePayConfigReqVO createPayConfigReqVO) {

        PayConfigDO payConfigDO = PayConfigConvert.INSTANCE.convert(createPayConfigReqVO);

        payConfigDO.setConfig(parseConfig(createPayConfigReqVO.getCode(),createPayConfigReqVO.getConfig()));

        System.out.println(payConfigMapper.insert(payConfigDO));
    }
}
