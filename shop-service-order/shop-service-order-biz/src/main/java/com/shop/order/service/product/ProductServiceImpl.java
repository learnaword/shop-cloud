package com.shop.order.service.product;

import com.shop.order.dal.dataobject.ProductDO;
import com.shop.order.dal.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    ProductMapper productMapper;

    @Override
    public ProductDO getById(Integer productId){

        return productMapper.selectById(productId);

    }
}
