package com.shop.order.service.product;

import com.shop.order.dal.dataobject.ProductDO;

public interface ProductService {
    ProductDO getById(Integer productId);

    Boolean subStock(Integer productId,Integer num);

    Boolean rollbackStock(Integer productId,int num);

}
