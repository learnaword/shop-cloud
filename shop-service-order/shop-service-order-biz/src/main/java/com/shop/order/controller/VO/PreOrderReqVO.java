package com.shop.order.controller.VO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class PreOrderReqVO {

    //下单类型
    @NotBlank(message = "预下单类型不能为空")
    private String preOrderType;

    //下单详情
    private List<PreOrderDetailVO> orderDetails;

}
