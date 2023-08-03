package com.shop.pay.controller.app;

import cn.hutool.core.collection.CollUtil;
import com.shop.common.pojo.CommonResult;
import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.app.vo.PayAppPageReqVO;
import com.shop.pay.controller.app.vo.PayAppPageRespVO;
import com.shop.pay.convert.app.AppConvert;
import com.shop.pay.dal.dataobject.PayAppDO;
import com.shop.pay.dal.dataobject.PayConfigDO;
import com.shop.pay.service.impl.PayAppServiceImpl;
import com.shop.pay.service.impl.PayConfigServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.shop.common.pojo.CommonResult.success;


@RestController
@RequestMapping("/payApp")
public class PayAppController {

    @Resource
    private PayAppServiceImpl payAppService;
    @Resource
    private PayConfigServiceImpl payAppConfigService;

    @RequestMapping("/list")
    public CommonResult<PageResult<PayAppPageRespVO>> getPayAppPage(@Valid PayAppPageReqVO payAppPageReqVO){

        //获取app信息
        PageResult<PayAppDO> pageResult = payAppService.getPayAppPage(payAppPageReqVO);

        //获取app对应的配置信息
        Collection<Long> appIds = convertList(pageResult.getList(), PayAppDO::getId);
        List<PayConfigDO> payAppConfigs= payAppConfigService.getAppConfigListByAppIds(appIds);


        return success(AppConvert.INSTANCE.convertPage(pageResult, payAppConfigs));
    }

    public static <T, U> List<U> convertList(Collection<T> from, Function<T, U> func) {
        if (CollUtil.isEmpty(from)) {
            return new ArrayList<>();
        }

        return from.stream().map(func).filter(Objects::nonNull).collect(Collectors.toList());
    }


}
