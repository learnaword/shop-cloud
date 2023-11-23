package com.shop.order;

import com.shop.enums.ApiConstants;
import com.shop.order.dto.OrderRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = ApiConstants.NAME,fallbackFactory = OrderApiFallbackFactory.class,path =ApiConstants.PREFIX + "/order")
public interface OrderApi {
    String PREFIX = ApiConstants.PREFIX + "/order";

    @PostMapping( PREFIX + "/get")
    OrderRespDTO getOrderById(@RequestBody Integer id);
}
