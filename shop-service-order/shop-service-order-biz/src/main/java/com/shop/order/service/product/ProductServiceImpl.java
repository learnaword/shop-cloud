package com.shop.order.service.product;

import com.shop.order.dal.dataobject.ProductDO;
import com.shop.order.dal.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDO getById(Integer productId){

        return productMapper.selectById(productId);

    }
}
