package com.nainai.exception;

/**
 * Created by haopeng yan on 2018/1/3 14:40.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface OpsException {

    /**
     * 获取错误编码
     *
     * @return 错误编码
     */
    String getErrCode();

    /**
     * 获取错误详细信息
     *
     * @return 错误详细信息
     */
    String getErrDtlMsg();

    /**
     * 获取错误描述信息
     *
     * @return 错误描述信息
     */
    String getErrMsg();
}
