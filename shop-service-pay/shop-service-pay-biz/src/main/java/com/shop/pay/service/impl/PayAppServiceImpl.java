package com.shop.pay.service.impl;

import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.app.vo.PayAppPageReqVO;
import com.shop.pay.dal.dataobject.PayAppDO;
import com.shop.pay.dal.mapper.PayAppMapper;
import com.shop.pay.service.PayAppService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PayAppServiceImpl implements PayAppService {

    @Resource
    private PayAppMapper payAppMapper;

    @Override
    public PageResult<PayAppDO> getPayAppPage(PayAppPageReqVO payAppPageReqVO) {
        return payAppMapper.selectPage(payAppPageReqVO);
    }

    @Override
    public PayAppDO getPayAppById(Long payAppid) {
        return payAppMapper.selectById(payAppid);
    }
}
