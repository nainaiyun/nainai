package com.nainai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by haopeng yan on 2018/1/4 17:35.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Controller
public class ErrorController {
    @GetMapping("/400")
    public String badRequest() {
        return "error/400";
    }

    @GetMapping("/404")
    public String notFound() {
        return "error/404";
    }

    @GetMapping("/500")
    public String serverError() {
        return "error/500";
    }
}
