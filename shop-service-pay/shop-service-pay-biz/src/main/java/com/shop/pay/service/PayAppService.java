package com.shop.pay.service;


import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.app.vo.PayAppPageReqVO;
import com.shop.pay.dal.dataobject.PayAppDO;

public interface PayAppService {
    PageResult<PayAppDO> getPayAppPage(PayAppPageReqVO payAppPageReqVO);

    PayAppDO getPayAppById(Long payAppid);
}
