package com.shop.pay.convert.config;


import com.shop.pay.controller.config.vo.CreatePayConfigReqVO;
import com.shop.pay.controller.config.vo.UpdatePayConfigReqVO;
import com.shop.pay.dal.dataobject.PayConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayConfigConvert {
    PayConfigConvert INSTANCE = Mappers.getMapper(PayConfigConvert.class);

    @Mapping(target = "config",ignore = true)
    PayConfigDO convert(UpdatePayConfigReqVO bean);

    @Mapping(target = "config",ignore = true)
    PayConfigDO convert(CreatePayConfigReqVO bean);
}
