package com.shop.enums;

import com.shop.common.exception.ErrorCode;
/*
*order错误码
*
* code：1-001-000-000
*
 */
public interface ErrorCodeConstants {

    //===========订单1001001000================
    ErrorCode PRODUCT_ID_NOT_NULL = new ErrorCode(1001001001, "产品ID不能为空");
    ErrorCode PRODUCT_NUM_IS_ZERO = new ErrorCode(1001001002, "购买商品必须大于0");
    ErrorCode PRODUCT_NOT_FOUND = new ErrorCode(1001001003, "商品信息不存在，请刷新后重新选择");
    ErrorCode PRODUCT_OFF_SALE = new ErrorCode(1001001004, "商品已下架，请刷新后重新选择");
    ErrorCode PRODUCT_OUT_OF_STOCK = new ErrorCode(1001001005, "商品库存不足");
    ErrorCode PRE_ORDER_NOT_FOUND = new ErrorCode(1001001006, "预下单订单不存在");



}
