package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopClassify;
import com.nainai.mapper.ShopClassifyMapper;
import com.nainai.service.ShopClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/11 15:35.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopClassifyService")
public class ShopClassifyServiceImpl implements ShopClassifyService{
    @Autowired
    private ShopClassifyMapper shopClassifyMapper;

    @Override
    public int insertShopClassify(ShopClassify shopClassify) {
        return shopClassifyMapper.insert(shopClassify);
    }

    @Override
    public int updateByPrimaryKeySelective(ShopClassify shopClassify) {
        return shopClassifyMapper.updateByPrimaryKeySelective(shopClassify);
    }

    @Override
    public int deleteShopClassifyId(String id) {
        return shopClassifyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopClassifyId(String id) {
        JSONObject shopClassifyJsonObject = new JSONObject();
        Optional<ShopClassify> shopClassify = Optional.ofNullable(shopClassifyMapper.selectByPrimaryKey(id));
        shopClassify.ifPresent(e -> shopClassifyJsonObject.put("shopClassify",e));
        return shopClassifyJsonObject;
    }

    @Override
    public JSONObject selectShopClassifyByShopId(String shopId,int isBackgroundSystem) {
        JSONObject shopClassifyJsonObject = new JSONObject();
        Optional<List<ShopClassify>> optional;
        if (isBackgroundSystem==1){
            optional= Optional.ofNullable(shopClassifyMapper.selectShopClassifyByShopIdBS(shopId));
        }else {
            optional= Optional.ofNullable(shopClassifyMapper.selectShopClassifyByShopId(shopId));
        }

        optional.ifPresent(e -> shopClassifyJsonObject.put("shopClassifys",e));
        return shopClassifyJsonObject;
    }

    @Override
    public JSONObject selectShopClassifyAll() {
        JSONObject shopClassifyJsonObject = new JSONObject();
        Optional<List<ShopClassify>> shopClassifys = Optional.ofNullable(shopClassifyMapper.selectShopClassifyAll());
        shopClassifys.ifPresent(e -> shopClassifyJsonObject.put("shopClassify",e));
        return shopClassifyJsonObject;
    }

    @Override
    public JSONObject selectShopClassifyAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject shopClassifyJsonObject = new JSONObject();
        Optional<List<ShopClassify>> shopClassifys = Optional.ofNullable(shopClassifyMapper.selectShopClassifyAll());
        shopClassifys.ifPresent(e -> shopClassifyJsonObject.put("shopClassify",e));
        long count = PageHelper.count(()->shopClassifyMapper.selectShopClassifyAll());
        shopClassifyJsonObject.put("count",count);
        return shopClassifyJsonObject;
    }
}
