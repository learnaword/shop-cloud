package com.shop.order.service.order;

import com.shop.order.controller.VO.OrderCreateReqVO;
import com.shop.order.controller.VO.OrderCreateRespVO;
import com.shop.order.controller.VO.PreOrderReqVO;
import com.shop.order.controller.VO.PreOrderRespVO;
import com.shop.order.dal.dataobject.OrderDO;

public interface OrderService {
    PreOrderRespVO preOrder(PreOrderReqVO preOrderReqVO);

    OrderCreateRespVO orderCreate(OrderCreateReqVO orderCreateReqVO);

    OrderDO getOrderById(Long id);
}
