package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopSpread;
import com.nainai.mapper.ShopSpreadMapper;
import com.nainai.service.ShopSpreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/16 12:03.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopSpreadService")
public class ShopSpreadServiceImpl implements ShopSpreadService {
    @Autowired
    private ShopSpreadMapper shopSpreadMapper;
    @Override
    public int insertShopSpread(ShopSpread shopSpread) {
        return shopSpreadMapper.insert(shopSpread);
    }

    @Override
    public int updateShopSpreadIdSelective(ShopSpread shopSpread) {
        return shopSpreadMapper.updateByPrimaryKeySelective(shopSpread);
    }

    @Override
    public int deleteShopSpreadId(String id) {
        return shopSpreadMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopSpreadeId(String id) {
        JSONObject shopSpreadJsonObject = new JSONObject();
        Optional<ShopSpread> shopSpread = Optional.ofNullable(shopSpreadMapper.selectByPrimaryKey(id));
        shopSpread.ifPresent(e -> shopSpreadJsonObject.put("shopSpread",e));
        return shopSpreadJsonObject;
    }

    @Override
    public JSONObject selectShopSpreadAndProNameShopId(String shopId,int isBackgroundSystem) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<Map<String,String>>> optionalMaps;
        if (isBackgroundSystem == 1) {
            optionalMaps = Optional.ofNullable(shopSpreadMapper.selectShopSpreadAndProNameShopIdBS(shopId));
        } else {
            optionalMaps = Optional.ofNullable(shopSpreadMapper.selectShopSpreadAndProNameShopId(shopId));
        }
        optionalMaps.ifPresent(e -> jsonObject.put("shopSpreads",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopSpreadAll() {
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopSpread>> shopSpreads = Optional.ofNullable(shopSpreadMapper.selectShopSpreadAll());
        shopSpreads.ifPresent(e -> jsonObject.put("shopSpreads",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopSpreadAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopSpread>> shopSpreads = Optional.ofNullable(shopSpreadMapper.selectShopSpreadAll());
        shopSpreads.ifPresent(e -> jsonObject.put("shopSpreads",e));
        long count = PageHelper.count(()->shopSpreadMapper.selectShopSpreadAll());
        jsonObject.put("count",count);
        return jsonObject;
    }
}
