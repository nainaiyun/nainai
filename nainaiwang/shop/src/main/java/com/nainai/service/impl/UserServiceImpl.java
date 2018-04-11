package com.nainai.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.User;
import com.nainai.mapper.UserMapper;
import com.nainai.service.UserService;
import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hp yan on 2017/1/5.
 *
 * @author hp yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2017. hp yan All Rights Received
 */
@Service(value = "userService")
@EnableCaching
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUserIdSelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserId(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectUserId(Integer id) {
        JSONObject userJsonObject = new JSONObject();
        Optional<User> user = Optional.ofNullable(userMapper.selectByPrimaryKey(id));
        user.ifPresent(e -> userJsonObject.put("user",e));
        return userJsonObject;
    }

    @Override
    public JSONObject selectUserShopId(String shopId) {
        JSONObject userJsonObject = new JSONObject();
        Optional<User> user = Optional.ofNullable(userMapper.selectUserShopId(shopId));
        user.ifPresent(e -> userJsonObject.put("user",e));
        return userJsonObject;
    }

    @Override
    public JSONObject selectUserAll() {
        JSONObject usersJsonObject = new JSONObject();
        Optional<List<User>> users = Optional.ofNullable(userMapper.selectUserAll());
        users.ifPresent(e -> usersJsonObject.put("users",e));
        return usersJsonObject;
    }

    @Override
    public JSONObject selectUserAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject usersJsonObject = new JSONObject();
        Optional<List<User>> users = Optional.ofNullable(userMapper.selectUserAll());
        users.ifPresent(e -> usersJsonObject.put("users",e));

        long count = PageHelper.count(()->userMapper.selectUserAll());
        usersJsonObject.put("count",count);
        return usersJsonObject;
    }

    @Override
    public JSONObject selectUserByUsername(String username) {
        JSONObject userJsonObject = new JSONObject();
        Optional<User> user = Optional.ofNullable(userMapper.selectUserByUsername(username));
        user.ifPresent(e -> userJsonObject.put("user",e));
        return userJsonObject;
    }


    @Override
    public JSONObject selectShopIdByUsername(String username){
        JSONObject mapJsonObject = new JSONObject();
        Optional<Map<String ,String>> map = Optional.ofNullable(userMapper.selectShopIdByUsername(username));
        map.ifPresent(e->mapJsonObject.put("map",e));
        return mapJsonObject;
    }

    @Override
    public JSONObject selectUserTypeByUsername(String username) {
        JSONObject mapJsonObject = new JSONObject();
        Optional<Map<String ,String>> map = Optional.ofNullable(userMapper.selectUserTypeByUsername(username));
        map.ifPresent(e->mapJsonObject.put("map",e));
        return mapJsonObject;
    }

    @Override
    public JSONObject selectSession(String username) {
        JSONObject jsonObject = new JSONObject();
        Optional<Map<String ,String>> optionalMap = Optional.ofNullable(userMapper.selectSession(username));
        optionalMap.ifPresent(e->{
            List<String> reusltList = unserializePHParray(e.get("session_data"));
            System.out.println(reusltList);
            System.out.println(e);
            jsonObject.put("sessionDate",reusltList);

        });
        return jsonObject;
    }

    @Override
    public JSONObject selectAccount(Integer id) {
        JSONObject jsonObject = new JSONObject();
        Optional<Map<String ,String>> optionalMap = Optional.ofNullable(userMapper.selectAccount(id));
        optionalMap.ifPresent(e->jsonObject.put("account",e));
        return jsonObject;
    }

    @Override
    public JSONObject isLogin(String username) {
        JSONObject jsonObject = new JSONObject();
        Optional<Map<String ,Object>> optionalMap = Optional.ofNullable(userMapper.isLogin(username));
        optionalMap.ifPresent(e->{
            if (e.get("session_expire")!=null){
                Integer dbTime =(Integer)e.get("session_expire");
                Integer time =(int) Calendar.getInstance().getTimeInMillis();
                System.out.println("当前时间戳："+Calendar.getInstance().getTimeInMillis());
                System.out.println("dbTime"+dbTime);
                int i = dbTime.compareTo(time);
                System.out.println(i);
                if (1==1){
                    jsonObject.put("isLogin",1);
                }else {
                    jsonObject.put("isLogin",0);
                }
            }else {
                jsonObject.put("isLogin",0);
            }

        });
        System.out.println(jsonObject.toString().length());
        if(jsonObject.toString().length()<=2){
            jsonObject.put("isLogin",0);
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectUsernameBySessionId(String sd) {
        JSONObject jsonObject = new JSONObject();
        List<Map<String ,Object>> list = userMapper.selectUsernameBySessionId(sd);
        if (list.size()!=1){
            jsonObject.put("username","");
        }else {
            if (list.get(0).get("session_expire")==null&&list.get(0).get("username").toString()==null){
                jsonObject.put("username","");
            }else {
                Integer dbTime =(Integer)list.get(0).get("session_expire");
                Integer time =(int) Calendar.getInstance().getTimeInMillis();
                System.out.println("当前时间戳："+Calendar.getInstance().getTime());
                System.out.println("过期时间戳："+dbTime);
                int i = dbTime.compareTo(time/1000);
                System.out.println(i);
                if (i==1){
                    jsonObject.put("username",list.get(0).get("username"));
                }else {
                    jsonObject.put("username","");
                }
            }

        }
        return jsonObject;
    }

    /**
     * 对php序列化的字符串，进行反序列化
     * @param content
     * @return
     */
    public static List<String> unserializePHParray(String content){
        List<String> list = new ArrayList<>();
        PHPSerializer p = new PHPSerializer();
        if (StringUtils.isEmpty(content)) {
            return list;
        }
        try {
            AssocArray array = (AssocArray) p.unserialize(content.getBytes());
            for (int i = 0; i < array.size(); i++) {
                String t = (String) Cast.cast(array.get(i), String.class);
                list.add(t);
            }
        }catch (Exception e){
            System.out.println("反序列化PHParray: " + content + " 失败！！！" );
        }
        return list;
    }


}
