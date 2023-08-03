package com.shop.pay.service;

import com.shop.pay.controller.config.vo.CreatePayConfigReqVO;
import com.shop.pay.controller.config.vo.UpdatePayConfigReqVO;
import com.shop.pay.dal.dataobject.PayConfigDO;

import java.util.Collection;
import java.util.List;

public interface PayConfigService {
    List<PayConfigDO> getAppConfigListByAppIds(Collection<Long> appIds);

    public PayConfigDO getPayConfigByCodeAndpayAppid(String code, Long payAppid);

    public PayConfigDO getPayConfig(Long id);

    public void updatePayConfig(UpdatePayConfigReqVO updatePayConfigReqVO);

    public void createPayConfig(CreatePayConfigReqVO createPayConfigReqVO);
}
