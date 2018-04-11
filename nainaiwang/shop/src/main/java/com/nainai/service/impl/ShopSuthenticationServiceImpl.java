package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopSuthentication;
import com.nainai.mapper.ShopSuthenticationMapper;
import com.nainai.service.ShopSuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/15 09:13.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopSuthenticationService")
public class ShopSuthenticationServiceImpl implements ShopSuthenticationService {
    @Autowired
    private ShopSuthenticationMapper shopSuthenticationMapper;

    @Override
    public int insertShopSuthentication(ShopSuthentication shopSuthentication) {
        return shopSuthenticationMapper.insert(shopSuthentication);
    }

    @Override
    public int updateShopStyleIdSelective(ShopSuthentication shopSuthentication) {
        return shopSuthenticationMapper.updateByPrimaryKeySelective(shopSuthentication);
    }

    @Override
    public int deleteShopSuthenticationId(String id) {
        return shopSuthenticationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopSuthenticationId(String id) {
        JSONObject shopSuthenticationJsonObject = new JSONObject();
        Optional<ShopSuthentication> shopSuthentication = Optional.ofNullable(shopSuthenticationMapper.selectByPrimaryKey(id));
        shopSuthentication.ifPresent(e -> shopSuthenticationJsonObject.put("shopSuthentication",e));
        return shopSuthenticationJsonObject;
    }

    @Override
    public JSONObject selectShopSuthenticationShopId(String shopId) {
        JSONObject shopSuthenticationsJsonObject = new JSONObject();
        Optional<List<ShopSuthentication>> shopSuthentications = Optional.ofNullable(shopSuthenticationMapper.selectShopSuthenticationShopId(shopId));
        shopSuthentications.ifPresent(e -> shopSuthenticationsJsonObject.put("shopSuthentications",e));
        return shopSuthenticationsJsonObject;
    }

    @Override
    public JSONObject selectShopSuthenticationAll() {
        JSONObject shopSuthenticationsJsonObject = new JSONObject();
        Optional<List<ShopSuthentication>> shopSuthentications = Optional.ofNullable(shopSuthenticationMapper.selectShopSuthenticationAll());
        shopSuthentications.ifPresent(e -> shopSuthenticationsJsonObject.put("shopSuthentications",e));
        return shopSuthenticationsJsonObject;
    }

    @Override
    public JSONObject selectShopSuthenticationAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject shopSuthenticationsJsonObject = new JSONObject();
        Optional<List<ShopSuthentication>> shopSuthentications = Optional.ofNullable(shopSuthenticationMapper.selectShopSuthenticationAll());
        shopSuthentications.ifPresent(e -> shopSuthenticationsJsonObject.put("shopSuthentications",e));

        long count = PageHelper.count(()->shopSuthenticationMapper.selectShopSuthenticationAll());
        shopSuthenticationsJsonObject.put("count",count);
        return shopSuthenticationsJsonObject;
    }
}
