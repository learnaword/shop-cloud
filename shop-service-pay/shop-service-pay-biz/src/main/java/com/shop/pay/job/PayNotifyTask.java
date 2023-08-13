package com.shop.pay.job;

import com.shop.pay.service.notify.PayNotifyTaskService;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PayNotifyTask {
    @Resource
    PayNotifyTaskService payNotifyTaskService;

    @XxlJob("payNotifyTask")
    public void execute() {
        payNotifyTaskService.executeNotify();
    }
}
