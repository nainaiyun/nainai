package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopStyle;
import com.nainai.mapper.ShopStyleMapper;
import com.nainai.service.ShopStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/15 09:01.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopStyleService")
public class ShopStyleServiceImpl implements ShopStyleService{

    @Autowired
    private ShopStyleMapper shopStyleMapper;

    @Override
    public int insertShopStyle(ShopStyle shopStyle) {
        return shopStyleMapper.insert(shopStyle);
    }

    @Override
    public int updateShopStyleIdSelective(ShopStyle shopStyle) {
        return shopStyleMapper.updateByPrimaryKeySelective(shopStyle);
    }

    @Override
    public int deleteShopStyleId(String id) {
        return shopStyleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopStyleId(String id) {
        JSONObject shopStyleJsonObject = new JSONObject();
        Optional<ShopStyle> shopStyle = Optional.ofNullable(shopStyleMapper.selectByPrimaryKey(id));
        shopStyle.ifPresent(e -> shopStyleJsonObject.put("shopStyle",e));
        return shopStyleJsonObject;
    }

    @Override
    public JSONObject selectShopStyleShopId(String shopId) {
        JSONObject shopStylesJsonObject = new JSONObject();
        Optional<List<ShopStyle>> shopStyles = Optional.ofNullable(shopStyleMapper.selectShopStyleShopId(shopId));
        shopStyles.ifPresent(e -> shopStylesJsonObject.put("shopStyles",e));
        return shopStylesJsonObject;
    }

    @Override
    public JSONObject selectShopStyleAll() {
        JSONObject shopStylesJsonObject = new JSONObject();
        Optional<List<ShopStyle>> shopStyles = Optional.ofNullable(shopStyleMapper.selectShopStyleAll());
        shopStyles.ifPresent(e -> shopStylesJsonObject.put("shopStyles",e));
        return shopStylesJsonObject;
    }

    @Override
    public JSONObject selectShopStyleAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        JSONObject shopStylesJsonObject = new JSONObject();
        Optional<List<ShopStyle>> shopStyles = Optional.ofNullable(shopStyleMapper.selectShopStyleAll());
        shopStyles.ifPresent(e -> shopStylesJsonObject.put("shopStyles",e));

        long count = PageHelper.count(()->shopStyleMapper.selectShopStyleAll());
        shopStylesJsonObject.put("count",count);
        return shopStylesJsonObject;
    }
}
