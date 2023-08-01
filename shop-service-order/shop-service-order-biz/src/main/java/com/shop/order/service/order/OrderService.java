package com.shop.order.service.order;

import com.shop.order.controller.VO.PreOrderReqVO;
import com.shop.order.controller.VO.PreOrderResqVO;

public interface OrderService {
    PreOrderResqVO preOrder(PreOrderReqVO preOrderReqVO);
}
