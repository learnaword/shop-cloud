package com.shop.order.dal.mapper;

import com.shop.fremework.mybatis.mapper.BaseMapperX;
import com.shop.order.dal.dataobject.ProductDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapperX<ProductDO> {

}
