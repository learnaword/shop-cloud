package com.shop.pay.controller.config;

import com.shop.common.pojo.CommonResult;
import com.shop.pay.service.impl.PayConfigServiceImpl;
import com.shop.pay.controller.config.vo.CreatePayConfigReqVO;
import com.shop.pay.controller.config.vo.UpdatePayConfigReqVO;
import com.shop.pay.dal.dataobject.PayConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pay/config")
public class PayConfigController {

    @Resource

    private PayConfigServiceImpl payConfigService;

    @RequestMapping("/get")
    public CommonResult<PayConfigDO> getPayConfig(@RequestParam(value = "id", required = false) Long id,
                                                  @RequestParam(value = "payAppid", required = false) Long appId,
                                                  @RequestParam(value = "code", required = false) String code){
        PayConfigDO payConfig = null;
        if( id != null ){
            payConfig = payConfigService.getPayConfig(id);
        }

        if(appId != null&&code != null){
            payConfig = payConfigService.getPayConfigByCodeAndpayAppid(code,appId);
        }

        return CommonResult.success(payConfig);
    }

    @RequestMapping("/update")
    public CommonResult<Boolean> updatePayConfig(UpdatePayConfigReqVO updatePayConfigReqVO){
        PayConfigDO payConfig = payConfigService.getPayConfig(111l);

        payConfigService.updatePayConfig(updatePayConfigReqVO);
        return CommonResult.success(true);
    }

    @RequestMapping("/create")
    public CommonResult<Boolean> createPayConfig(CreatePayConfigReqVO createPayConfigReqVO){

        payConfigService.createPayConfig(createPayConfigReqVO);
        return CommonResult.success(true);
    }
}
