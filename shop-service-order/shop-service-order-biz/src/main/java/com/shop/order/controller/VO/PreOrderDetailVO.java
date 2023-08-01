package com.shop.order.controller.VO;

import lombok.Data;

@Data
public class PreOrderDetailVO {

    //商品id
    private Integer productId;


    //购买商品数量
    private Integer productNum;

    //商品类型
    private Integer productType;
}
