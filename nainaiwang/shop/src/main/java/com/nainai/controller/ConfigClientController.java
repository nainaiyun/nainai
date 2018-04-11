package com.nainai.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/1/19 11:40.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RefreshScope
public class ConfigClientController {
//    @Value("${profile}")
//    private String profile;
//
//    @GetMapping("/hello")
//    public String hello() {
//        return this.profile;
//    }
}
