package com.shop.order.dal.mapper;

import com.shop.framework.mybatis.mapper.BaseMapperX;
import com.shop.order.dal.dataobject.OrderDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapperX<OrderDO> {
}
