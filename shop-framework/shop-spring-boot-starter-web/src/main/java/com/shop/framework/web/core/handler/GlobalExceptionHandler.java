package com.shop.framework.web.core.handler;

import com.shop.common.exception.ServiceException;
import com.shop.common.pojo.CommonResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public CommonResult<?> ServiceExceptionHandler(ServiceException ex){
        log.warn("[ServiceException]", ex);
        System.out.println("111111111");
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }
}
