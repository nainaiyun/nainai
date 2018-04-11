package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.User;

/**
 * Created by haopeng yan on 2018/1/4 17:40.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface UserService {

    int insertUser(User user);

    int updateUserIdSelective(User user);

    int deleteUserId(Integer id);

    JSONObject selectUserId(Integer id);

    JSONObject selectUserShopId(String shopId);

    JSONObject selectUserAll();

    JSONObject selectUserAllPage(int pageNum, int pageSize);

    JSONObject selectUserByUsername(String username);

    JSONObject selectShopIdByUsername(String username);

    JSONObject selectUserTypeByUsername(String username);

    JSONObject selectSession(String username);

    JSONObject selectAccount(Integer id);

    JSONObject isLogin(String username);

    JSONObject selectUsernameBySessionId(String sd);
}
