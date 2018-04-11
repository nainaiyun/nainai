package com.nainai.controller;

import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by haopeng yan on 2018/1/18 12:01.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Controller
@RequestMapping(value = "/bid")
public class BidController {


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Result test(){
        String result = new RestTemplate().getForObject("http://sidecarphp/health",String.class);
        return ResultGenerator.genSuccessResult(result);
    }
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(HttpServletRequest request, Model model){
        model.addAttribute("name","nihaoa");
        System.out.println(request.getSession().getId());
        return "front/login";
    }

}
