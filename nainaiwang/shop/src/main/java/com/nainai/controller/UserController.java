package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by haopeng yan on 2018/1/4 16:35.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/user")
public class UserController implements Serializable {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 根据用户名查询用户信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据用户名查询用户信息", notes = "根据用户名查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/selectUserByUsername", method = RequestMethod.POST)
    public Result selectUserByUsername(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        return ResultGenerator.genSuccessResult(userService.selectUserByUsername(username));
    }

    /**
     * 根据用户名查询店铺id判断是否有店铺并且经过认证
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "判断是否有店铺", notes = "根据用户名查询店铺id判断是否有店铺并且经过认证，返回店铺编号")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/selectShopIdByUsername", method = RequestMethod.POST)
    public Result selectShopIdByUsername(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession().getAttribute("login_account"));
        return ResultGenerator.genSuccessResult(userService.selectShopIdByUsername(username));
    }

    /**
     * 根据用户名查询是企业账户还是个人账户
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "判断用户类型", notes = "根据用户名查询user表中type判断是企业账户还是个人照顾，1:企业账户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/selectUserTypeByUsername", method = RequestMethod.POST)
    public Result selectUserTypeByUsername(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        System.out.println(request.getSession().getId());
        return ResultGenerator.genSuccessResult(userService.selectUserTypeByUsername(username));
    }

    /**
     * 根据用户名查询session
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据用户名查询session", notes = "根据用户名查询session")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/selectSession", method = RequestMethod.POST)
    public Result selectSession(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String session = jsonObject.getString("session");
        System.out.println(session);
        System.out.println(request.getSession().getId());
        return ResultGenerator.genSuccessResult(userService.selectSession(username));
    }

    /**
     * 根据用户名查询用户余额以及冻结余额
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据用户名查询用户余额以及冻结余额", notes = "根据用户名查询用户余额以及冻结余额")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "id", value = "用户id")
    })
    @RequestMapping(value = "/selectAccount", method = RequestMethod.POST)
    public Result selectAccount(@RequestBody JSONObject jsonObject) {
        Integer id = jsonObject.getInteger("id");
        return ResultGenerator.genSuccessResult(userService.selectAccount(id));
    }

    /**
     * 根据用户名判断是否登录
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据用户名判断是否登录", notes = "根据用户名判断是否登录")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户名")
    })
    @RequestMapping(value = "/selectIsLogin", method = RequestMethod.POST)
    public Result selectIsLogin(@RequestBody JSONObject jsonObject) {
        String username= jsonObject.getString("username");
        return ResultGenerator.genSuccessResult(userService.isLogin(username));
    }
    /**
     * 根据用户名判断是否登录
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据用户名判断是否登录", notes = "根据用户名判断是否登录")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "sd", value = "session_id")
    })
    @RequestMapping(value = "/selectUsernameBySessionId", method = RequestMethod.POST)
    public Result selectUsernameBySessionId(@RequestBody JSONObject jsonObject) {
        String sd= jsonObject.getString("sd");
        return ResultGenerator.genSuccessResult(userService.selectUsernameBySessionId(sd));
    }

    /**
     * 获取当前登录用户
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "获取当前登录用户", notes = "获取当前登录用户")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "sd", value = "session_id")
    })
    @RequestMapping(value = "/selectUsernameByInput", method = RequestMethod.POST)
    public Result selectUsernameByInput() {
        String uname = request.getRemoteUser();
        System.out.println(uname);
        return ResultGenerator.genSuccessResult(uname);
    }
}