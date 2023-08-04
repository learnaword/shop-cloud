package com.shop.order.convert;

import com.shop.common.pojo.PageResult;
import com.shop.order.dal.dataobject.OrderDO;
import com.shop.order.dto.OrderRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderConvert {
    OrderConvert INSTANCE = Mappers.getMapper(OrderConvert.class);

    OrderRespDTO convert(OrderDO orderDO);

}
