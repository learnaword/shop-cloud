package com.shop.order.api;

import com.shop.order.OrderApi;
import com.shop.order.convert.OrderConvert;
import com.shop.order.dal.dataobject.OrderDO;
import com.shop.order.dto.OrderRespDTO;
import com.shop.order.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class OrderApiImpl implements OrderApi {

    @Autowired
    OrderService orderService;
    @Override
    public OrderRespDTO getOrderById(Long id) {
        OrderDO orderDO = orderService.getOrderById(id);
        return OrderConvert.INSTANCE.convert(orderDO);
    }
}