package com.nainai.exception.handler;

import com.nainai.common.Result;
import com.nainai.common.ResultCode;
import com.nainai.exception.BusinessException;
import com.nainai.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by haopeng yan on 2018/1/3 14:58.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@ControllerAdvice
public class BusinessExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        Result result = new Result();
        result.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        if (e instanceof BusinessException) {
            BusinessException ex = (BusinessException) e;
            result.setMessage(ex.getErrMsg());
            result.setCode(ResultCode.FAIL);
        } else if (e instanceof SystemException) {
            SystemException ex = (SystemException) e;
            result.setMessage(ex.getErrMsg());
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR);
        } else {
            result.setCode(ResultCode.FAIL);
            LOGGER.error("系统异常", e);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
