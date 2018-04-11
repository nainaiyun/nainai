package com.nainai.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopNavigation;
import com.nainai.mapper.ShopNavigationMapper;
import com.nainai.service.ShopNavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/12 15:52.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopNavigationService")
public class ShopNavigationServiceImpl implements ShopNavigationService {
    @Autowired
    private ShopNavigationMapper shopNavigationMapper;

    @Override
    public int insertShopNavigation(ShopNavigation shopNavigation) {
        return shopNavigationMapper.insert(shopNavigation);
    }

    @Override
    public int updateShopNavigationIdSelective(ShopNavigation shopNavigation) {
        return shopNavigationMapper.updateByPrimaryKeySelective(shopNavigation);
    }

    @Override
    public int deleteShopNavigationId(String id) {
        return shopNavigationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopNavigationId(String id) {
        JSONObject shopNavigationJsonObject = new JSONObject();
        Optional<ShopNavigation> shopNavigation = Optional.ofNullable(shopNavigationMapper.selectByPrimaryKey(id));
        shopNavigation.ifPresent(e -> shopNavigationJsonObject.put("shopNavigation", e));
        return shopNavigationJsonObject;
    }

    @Override
    public JSONArray selectShopNavigationShopId(String shopId,int isBackgroundSystem) {
        JSONObject shopNavigationJsonObject = new JSONObject();
        JSONArray shopNavigationJsonArray = new JSONArray();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        Optional<List<ShopNavigation>> shopNavigationParents ;
        Optional<List<ShopNavigation>> shopNavigationSons;
        if (isBackgroundSystem ==1){
            shopNavigationParents = Optional.ofNullable(
                    shopNavigationMapper.selectShopNavigationParentShopIdBS(shopId));
            shopNavigationSons = Optional.ofNullable(
                    shopNavigationMapper.selectShopNavigationSonShopIdBS(shopId));
        }else {
            shopNavigationParents = Optional.ofNullable(
                    shopNavigationMapper.selectShopNavigationParentShopId(shopId));
            shopNavigationSons = Optional.ofNullable(
                    shopNavigationMapper.selectShopNavigationSonShopId(shopId));
        }

        shopNavigationParents.ifPresent(e -> {
            shopNavigationSons.ifPresent(f -> {
                e.forEach(g -> {
                    shopNavigationJsonObject.put("shopNavigationParents", g);
                    f.forEach(h -> {
                        if (g.getId().equals(h.getParentId())) {
                            shopNavigationJsonArray.add(h);
                        }
                    });
                    shopNavigationJsonObject.put("shopNavigationSons", shopNavigationJsonArray);
                    stringBuffer.append(shopNavigationJsonObject);
                    shopNavigationJsonArray.clear();
                    stringBuffer.append(",");
                });
            });
        });
        String str = stringBuffer.substring(0, stringBuffer.length() - 1);
        str += ("]");

        if (str.length()>2) {
            JSONArray myJsonArray = JSONArray.parseArray(str);
            return myJsonArray;
        }else {
            JSONArray myJsonArray = JSONArray.parseArray("[]");
            return myJsonArray;

        }

    }

    @Override
    public JSONObject selectShopNavigationAll() {
        JSONObject shopNavigationJsonObject = new JSONObject();
        Optional<List<ShopNavigation>> shopNavigations = Optional.ofNullable(shopNavigationMapper.selectShopNavigationAll());
        shopNavigations.ifPresent(e -> shopNavigationJsonObject.put("shopNavigations", e));
        return shopNavigationJsonObject;
    }

    @Override
    public JSONObject selectShopNavigationAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject shopNavigationJsonObject = new JSONObject();
        Optional<List<ShopNavigation>> shopNavigations = Optional.ofNullable(shopNavigationMapper.selectShopNavigationAll());
        shopNavigations.ifPresent(e -> shopNavigationJsonObject.put("shopNavigations", e));
        long count = PageHelper.count(()->shopNavigationMapper.selectShopNavigationAll());
        shopNavigationJsonObject.put("count",count);
        return shopNavigationJsonObject;
    }

    @Override
    public JSONObject selectShopNavigationParentShopId(String shopId) {
        JSONObject shopNavigationParentJsonObject = new JSONObject();
        Optional<List<ShopNavigation>> shopNavigationParents = Optional.ofNullable(
                shopNavigationMapper.selectShopNavigationParentShopId(shopId));
        shopNavigationParents.ifPresent(e -> shopNavigationParentJsonObject.put("shopNavigationParents", e));
        return shopNavigationParentJsonObject;
    }
}
