package com.shop.order.dal.dataobject;

import lombok.Data;

@Data
public class ProductDO {

    //商品id
    private int id;

    //是否删除
    private Boolean isDel;

    //是否展示
    private Boolean isShow;

    //库存
    private int stock;

    //商品名字
    private String name;
}
