package com.shop.order;

import com.shop.enums.ApiConstants;
import com.shop.order.dto.OrderRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = ApiConstants.NAME)
public interface OrderApi {
    String PREFIX = ApiConstants.PREFIX + "/order";

    @PostMapping(PREFIX + "/get")
    OrderRespDTO getOrderById(Long id);
}
