package com.shop.order.service.product;

import com.shop.order.dal.dataobject.ProductDO;

public interface ProductService {
    ProductDO getById(Integer productId);
}
