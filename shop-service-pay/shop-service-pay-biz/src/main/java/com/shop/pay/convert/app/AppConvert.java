package com.shop.pay.convert.app;

import com.shop.common.pojo.CollectionUtils;
import com.shop.common.pojo.PageResult;
import com.shop.pay.controller.app.vo.PayAppPageRespVO;
import com.shop.pay.dal.dataobject.PayAppDO;
import com.shop.pay.dal.dataobject.PayConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 支付应用信息 Convert
 *
 */
@Mapper
public interface AppConvert {

    AppConvert INSTANCE = Mappers.getMapper(AppConvert.class);
    PageResult<PayAppPageRespVO> convertPage(PageResult<PayAppDO> page);

   default PageResult<PayAppPageRespVO> convertPage(PageResult<PayAppDO> page, List<PayConfigDO> payConfigs){
        PageResult<PayAppPageRespVO> voPageResult = convertPage(page);
        // 处理 channel 关系
        Map<Long, Set<String>> appIdConfigsMap = CollectionUtils.convertMultiMap2(payConfigs, PayConfigDO::getPayAppid, PayConfigDO::getCode);
        voPageResult.getList().forEach(app -> app.setConfigCodes(appIdConfigsMap.get(app.getId())));
        return voPageResult;
    }

}
