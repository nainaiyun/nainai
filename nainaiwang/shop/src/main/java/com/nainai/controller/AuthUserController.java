package com.nainai.controller;


import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.SysUser;
import com.nainai.domain.User;
import com.nainai.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by haopeng yan on 2018/3/1 14:07.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
public class AuthUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthUserController.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 1. cas 服务端会通过post请求，并且把用户信息以"用户名:密码"进行Base64编码放在authorization请求头中
     * 2. 返回200状态码并且格式为{"@class":"org.apereo.cas.authentication.principal.SimplePrincipal","id":"casuser","attributes":{}} 是成功的
     * 2. 返回状态码403用户不可用；404账号不存在；423账户被锁定；428过期；其他登录失败
     *
     * @param httpHeaders
     * @return
     */
    @PostMapping("/login")
    public Object login(@RequestHeader HttpHeaders httpHeaders) {
        LOGGER.info("Rest api login.");
        LOGGER.info("request headers: {}", httpHeaders);
        User user = null;
        try {
            UserTemp userTemp = obtainUserFormHeader(httpHeaders);
            //尝试查找用户库是否存在
            user = userMapper.selectUserByUsername(userTemp.username);
            if (user != null) {
                if (!user.getPassword().equals(userTemp.password)) {
                    //密码不匹配
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
                }
                if (user.getStatus()==1) {
                    //锁定 423
                    return new ResponseEntity(HttpStatus.LOCKED);
                }
            } else {
                //不存在 404
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("", e);
            new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("[{}] login is ok", user.getUsername());
        //成功返回json


        SysUser admin = new SysUser().setUsername(user.getUsername()).
                setPassword(user.getPassword()).
                addAttribute("key", "keyVal");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",user.getUsername());
        jsonObject.put("@class","org.apereo.cas.authentication.principal.SimplePrincipal");
        jsonObject.put("attributes",null);
        System.out.println(admin);
        return jsonObject;
    }

    /**
     * 根据请求头获取用户名及密码
     *
     * @param httpHeaders
     * @return
     * @throws UnsupportedEncodingException
     */
    private UserTemp obtainUserFormHeader(HttpHeaders httpHeaders) throws UnsupportedEncodingException {
        /**
         *
         * This allows the CAS server to reach to a remote REST endpoint via a POST for verification of credentials.
         * Credentials are passed via an Authorization header whose value is Basic XYZ where XYZ is a Base64 encoded version of the credentials.
         */
        //根据官方文档，当请求过来时，会通过把用户信息放在请求头authorization中，并且通过Basic认证方式加密
        String authorization = httpHeaders.getFirst("authorization");//将得到 Basic Base64(用户名:密码)
        String baseCredentials = authorization.split(" ")[1];
        String usernamePassword = new String(Base64Utils.decodeFromString(baseCredentials), "UTF-8");//用户名:密码
        LOGGER.info("login user: {}", usernamePassword);
        String credentials[] = usernamePassword.split(":");
        System.out.println("解密的：" + convertMD5(convertMD5(credentials[1])));
        return new UserTemp(credentials[0], credentials[1]);
    }

    /**
     * 解析请求过来的用户
     */
    private class UserTemp {
        private String username;
        private String password;

        public UserTemp(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
}
