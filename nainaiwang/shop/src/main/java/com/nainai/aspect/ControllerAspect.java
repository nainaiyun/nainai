package com.nainai.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
/**
 * Created by haopeng yan on 2018/1/4 17:35.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut(value = "execution(* com.nainai.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        JSONObject logInfos = new JSONObject();

        String requestURI = request.getRequestURL().toString();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        String body = IOUtils.read(reader);
        Map<String, String[]> parameterMap = request.getParameterMap();
        logInfos.put("url", requestURI);
        logInfos.put("parameters", parameterMap);
        LOGGER.info(logInfos.toJSONString());
    }
}
