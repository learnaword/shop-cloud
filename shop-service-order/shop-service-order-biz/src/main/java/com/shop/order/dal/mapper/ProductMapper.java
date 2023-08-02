package com.shop.order.dal.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.common.pojo.PageResult;
import com.shop.order.dal.dataobject.ProductDO;
import com.shop.order.dal.mapper.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapperX<ProductDO> {

}
