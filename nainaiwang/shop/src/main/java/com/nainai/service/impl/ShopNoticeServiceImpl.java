package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopNotice;
import com.nainai.mapper.ShopNoticeMapper;
import com.nainai.service.ShopNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/14 23:14.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopNoticeService")
public class ShopNoticeServiceImpl implements ShopNoticeService {
    @Autowired
    private ShopNoticeMapper shopNoticeMapper;


    @Override
    public int insertShopNotice(ShopNotice shopNotice) {
        return shopNoticeMapper.insert(shopNotice);
    }

    @Override
    public int updateShopNoticeIdSelective(ShopNotice shopNotice) {
        return shopNoticeMapper.updateByPrimaryKeySelective(shopNotice);
    }

    @Override
    public int deleteShopNoticeId(String id) {
        return shopNoticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopNoticeId(String id) {
        JSONObject shopNoticeJsonObject = new JSONObject();
        Optional<ShopNotice> shopNotice = Optional.ofNullable(shopNoticeMapper.selectByPrimaryKey(id));
        shopNotice.ifPresent(e -> shopNoticeJsonObject.put("shopNotice", e));
        return shopNoticeJsonObject;
    }

    @Override
    public JSONObject selectShopNoticeNameShopIdPage(int pageNum, int pageSize, String shopId, int isBackgroundSystem) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<Map<String,String>>> optional;
        long count;
        if (isBackgroundSystem == 1) {
            optional = Optional.ofNullable(shopNoticeMapper.selectShopNoticeNameShopIdBS(shopId));
            count = PageHelper.count(() -> shopNoticeMapper.selectShopNoticeNameShopIdBS(shopId));
        } else {
            optional = Optional.ofNullable(shopNoticeMapper.selectShopNoticeNameShopId(shopId));
            count = PageHelper.count(() -> shopNoticeMapper.selectShopNoticeNameShopId(shopId));
        }
        optional.ifPresent(e -> jsonObject.put("shopNotice", e));
        jsonObject.put("count", count);
        return jsonObject;
    }

    @Override
    public JSONObject selectShopNoticeShopIdOne(String shopId) {
        JSONObject shopNoticeJsonObject = new JSONObject();
        Optional<List<ShopNotice>> shopNotice = Optional.of(shopNoticeMapper.selectShopNoticeShopId(shopId));
        shopNotice.ifPresent(e -> shopNoticeJsonObject.put("shopNotice", e.get(0)));
        return shopNoticeJsonObject;
    }

    @Override
    public JSONObject selectShopNoticeAll() {
        JSONObject shopNoticesJsonObject = new JSONObject();
        Optional<List<ShopNotice>> shopNotices = Optional.ofNullable(shopNoticeMapper.selectShopNoticeAll());
        shopNotices.ifPresent(e -> shopNoticesJsonObject.put("shopNotices", e));
        return shopNoticesJsonObject;
    }

    @Override
    public JSONObject selectShopNoticeAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject shopNoticesJsonObject = new JSONObject();
        Optional<List<ShopNotice>> shopNotices = Optional.ofNullable(shopNoticeMapper.selectShopNoticeAll());
        shopNotices.ifPresent(e -> shopNoticesJsonObject.put("shopNotices", e));
        long count = PageHelper.count(() -> shopNoticeMapper.selectShopNoticeAll());
        shopNoticesJsonObject.put("count", count);
        return shopNoticesJsonObject;
    }
}
