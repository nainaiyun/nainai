package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopModule;
import com.nainai.mapper.ShopModuleMapper;
import com.nainai.service.ShopModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/12 15:28.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopModuleService")
public class ShopModuleServiceImpl implements ShopModuleService{
    @Autowired
    private ShopModuleMapper shopModuleMapper;

    @Override
    public int insertShopModule(ShopModule shopModule) {
        return shopModuleMapper.insert(shopModule);
    }

    @Override
    public int updateShopModuleIdSelective(ShopModule shopModule) {
        return shopModuleMapper.updateByPrimaryKeySelective(shopModule);
    }

    @Override
    public int deleteShopModuleId(String id) {
        return shopModuleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopModuleId(String id) {
        JSONObject jsonObject = new JSONObject();
        Optional<ShopModule> optional = Optional.ofNullable(shopModuleMapper.selectByPrimaryKey(id));
        optional.ifPresent(e -> jsonObject.put("shopModule",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopModuleShopId(String shopId,int isBackgroundSystem) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopModule>> optional;
        if (isBackgroundSystem==1){
            optional= Optional.ofNullable(shopModuleMapper.selectShopModuleShopIdBS(shopId));
        }else {
            optional= Optional.ofNullable(shopModuleMapper.selectShopModuleShopId(shopId));
        }
        optional.ifPresent(e -> jsonObject.put("shopModules",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopModuleAll() {
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopModule>> optional = Optional.ofNullable(shopModuleMapper.selectShopModuleAll());
        optional.ifPresent(e -> jsonObject.put("shopModules",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopModuleAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopModule>> optional = Optional.ofNullable(shopModuleMapper.selectShopModuleAll());
        optional.ifPresent(e -> jsonObject.put("shopModules",e));
        long count = PageHelper.count(()->shopModuleMapper.selectShopModuleAll());
        jsonObject.put("count",count);
        return jsonObject;
    }
}
