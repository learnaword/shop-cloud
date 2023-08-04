package com.shop.order.api;

import com.shop.enums.ApiConstants;
import com.shop.order.OrderApi;
import com.shop.order.convert.OrderConvert;
import com.shop.order.dal.dataobject.OrderDO;
import com.shop.order.dto.OrderRespDTO;
import com.shop.order.service.order.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@RestController(ApiConstants.PREFIX + "/order")
public class OrderApiImpl implements OrderApi {

    @Resource
    OrderService orderService;

    @Override
    public OrderRespDTO getOrderById(Long id) {
        OrderDO orderDO = orderService.getOrderById(id);
        return OrderConvert.INSTANCE.convert(orderDO);
    }
}
