package com.shop.order.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderAutoCancelTask{

    @XxlJob("payOrderExpireJob")
    public ReturnT<String> execute(String param) {
        log.info("## custom job handler run. ##");
        return ReturnT.SUCCESS;
    }
}
