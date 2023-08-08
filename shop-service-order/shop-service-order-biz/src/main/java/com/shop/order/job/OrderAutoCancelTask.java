package com.shop.order.job;

import com.shop.order.service.job.OrderTaskService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderAutoCancelTask{
    @Resource
    OrderTaskService orderTaskService;

    @XxlJob("orderAutoCancelTask")
    public ReturnT<String> execute() {
        orderTaskService.autoCancelOrder();
        return ReturnT.SUCCESS;
    }
}
