package com.shop.order.service.order.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class OrderInfoDetailBO {

    private int productId;

    private String productName;

    private Integer payNum;

    private Integer productType;

    private BigDecimal price;
}
