package com.nainai.common;
/**
 * Created by haopeng yan on 2018/1/4 17:35.
 * 响应码枚举，参照HTTP状态码语义定义
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public enum ResultCode {
    /*成功*/
    SUCCESS("200"),
    /*失败*/
    FAIL("400"),
    /*未认证（签名错误)*/
    UNAUTHORIZED("401"),
    /*接口不存在*/
    NOT_FOUND("404"),
    /*服务器内部错误*/
    INTERNAL_SERVER_ERROR("500");

    public String code;

    ResultCode(String code) {
        this.code = code;
    }
}
