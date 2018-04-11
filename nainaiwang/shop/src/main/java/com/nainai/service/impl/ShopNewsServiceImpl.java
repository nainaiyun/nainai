package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopNews;
import com.nainai.mapper.ShopNewsMapper;
import com.nainai.service.ShopNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/29 09:30.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopNewsService")
public class ShopNewsServiceImpl implements ShopNewsService{
    @Autowired
    private ShopNewsMapper shopNewsMapper;

    @Override
    public int insertShopNews(ShopNews shopNews) {
        return shopNewsMapper.insert(shopNews);
    }

    @Override
    public int updateShopNewsIdSelective(ShopNews shopNews) {
        return shopNewsMapper.updateByPrimaryKeySelective(shopNews);
    }

    @Override
    public int deleteShopNewsId(String id) {
        return shopNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopNewsId(String id) {
        JSONObject jsonObject = new JSONObject();
        Optional<ShopNews> optionalShopNews = Optional.ofNullable(shopNewsMapper.selectByPrimaryKey(id));
        optionalShopNews.ifPresent(e->jsonObject.put("shopNews",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopNewsShopIdPage(int pageNum, int pageSize, String shopId,int isBackgroundSystem) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject jsonObject = new JSONObject();
        Optional<List<Map<String, String>>> optionalShopNews;
        long count;
        if (isBackgroundSystem == 1) {
            optionalShopNews = Optional.ofNullable(shopNewsMapper.selectShopNewsShopIdBS(shopId));
            count = PageHelper.count(()->shopNewsMapper.selectShopNewsShopIdBS(shopId));
        } else {
            optionalShopNews = Optional.ofNullable(shopNewsMapper.selectShopNewsShopId(shopId));
            count = PageHelper.count(()->shopNewsMapper.selectShopNewsShopId(shopId));
        }
        optionalShopNews.ifPresent(e->jsonObject.put("shopNewss",e));
        jsonObject.put("count",count);
        return jsonObject;
    }

    @Override
    public JSONObject selectShopNewsAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopNews>> optionalShopNews = Optional.ofNullable(shopNewsMapper.selectShopNewsAll());
        optionalShopNews.ifPresent(e->jsonObject.put("shopNewss",e));
        long count = PageHelper.count(()->shopNewsMapper.selectShopNewsAll());
        jsonObject.put("count",count);
        return jsonObject;
    }
}
