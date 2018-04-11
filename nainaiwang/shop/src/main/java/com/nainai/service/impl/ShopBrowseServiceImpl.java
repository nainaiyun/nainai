package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopBrowse;
import com.nainai.mapper.ShopBrowseMapper;
import com.nainai.service.ShopBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/12 11:12.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopBrowseService")
public class ShopBrowseServiceImpl implements ShopBrowseService {
    @Autowired
    private ShopBrowseMapper shopBrowseMapper;


    @Override
    public int insertShopBrowse(ShopBrowse shopBrowse) {
        return shopBrowseMapper.insert(shopBrowse);
    }

    @Override
    public int updateShopBrowseIdSelective(ShopBrowse shopBrowse) {
        return shopBrowseMapper.updateByPrimaryKeySelective(shopBrowse);
    }

    @Override
    public int deleteShopBrowseId(String id) {
        return shopBrowseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopBrowseId(String id) {
        JSONObject shopBrowseJsonObject = new JSONObject();
        Optional<ShopBrowse> shopBrowse= Optional.ofNullable(shopBrowseMapper.selectByPrimaryKey(id));
        shopBrowse.ifPresent(e->shopBrowseJsonObject.put("shopBrowse",e));
        return shopBrowseJsonObject;
    }

    @Override
    public JSONObject selectShopBrowseShopId(String shopId) {
        JSONObject shopBrowseJsonObject = new JSONObject();
        Optional<ShopBrowse> shopBrowses= Optional.ofNullable(shopBrowseMapper.selectShopBrowseShopId(shopId));
        shopBrowses.ifPresent(e->shopBrowseJsonObject.put("shopBrowses",e));
        return shopBrowseJsonObject;
    }

    @Override
    public JSONObject selectShopBrowseAll() {
        JSONObject shopBrowseJsonObject = new JSONObject();
        Optional<List<ShopBrowse>> shopBrowses= Optional.ofNullable(shopBrowseMapper.selectShopBrowseAll());
        shopBrowses.ifPresent(e->shopBrowseJsonObject.put("shopBrowses",e));
        return shopBrowseJsonObject;
    }

    @Override
    public JSONObject selectShopBrowseAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject shopBrowseJsonObject = new JSONObject();
        Optional<List<ShopBrowse>> shopBrowses= Optional.ofNullable(shopBrowseMapper.selectShopBrowseAll());
        shopBrowses.ifPresent(e->shopBrowseJsonObject.put("shopBrowses",e));
        long count = PageHelper.count(()->shopBrowseMapper.selectShopBrowseAll());
        shopBrowseJsonObject.put("count",count);
        return shopBrowseJsonObject;
    }
}
