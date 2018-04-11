package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopCarousel;
import com.nainai.mapper.ShopCarouselMapper;
import com.nainai.service.ShopCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/12 13:40.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopCarouselService")
public class ShopCarouselServiceImpl implements ShopCarouselService {
    @Autowired
    private ShopCarouselMapper shopCarouselMapper;

    @Override
    public int insertShopCarouselse(ShopCarousel shopCarousel) {
        return shopCarouselMapper.insert(shopCarousel);
    }

    @Override
    public int updateShopCarouselIdSelective(ShopCarousel shopCarousel) {
        return shopCarouselMapper.updateByPrimaryKeySelective(shopCarousel);
    }

    @Override
    public int deleteShopCarouselId(String id) {
        return shopCarouselMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopCarouselId(String id) {
        JSONObject shopCarouselsJsonObject = new JSONObject();
        Optional<ShopCarousel> shopCarousels = Optional.ofNullable(shopCarouselMapper.selectByPrimaryKey(id));
        shopCarousels.ifPresent(e -> shopCarouselsJsonObject.put("shopCarousels", e));
        return shopCarouselsJsonObject;
    }

    @Override
    public JSONObject selectShopCarouselShopId(String shopId, int isBackgroundSystem) {
        JSONObject shopCarouselsJsonObject = new JSONObject();
        Optional<List<ShopCarousel>> shopCarousels;
        Optional<List<Map<String,String>>> shopCarousels2;
        if (isBackgroundSystem == 1) {
            shopCarousels2 = Optional.ofNullable(shopCarouselMapper.selectShopCarouselShopIdBS(shopId));
            shopCarousels2.ifPresent(e -> shopCarouselsJsonObject.put("shopCarousels", e));
        } else {
            shopCarousels = Optional.ofNullable(shopCarouselMapper.selectShopCarouselShopId(shopId));
            shopCarousels.ifPresent(e -> shopCarouselsJsonObject.put("shopCarousels", e));
        }
        return shopCarouselsJsonObject;
    }

    @Override
    public JSONObject selectShopCarouselAll() {
        JSONObject shopCarouselsJsonObject = new JSONObject();
        Optional<List<ShopCarousel>> shopCarousels = Optional.ofNullable(
                shopCarouselMapper.selectShopCarouselAll());
        shopCarousels.ifPresent(e -> shopCarouselsJsonObject.put("shopCarousels", e));
        return shopCarouselsJsonObject;
    }

    @Override
    public JSONObject selectShopCarouselAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject shopCarouselsJsonObject = new JSONObject();
        Optional<List<ShopCarousel>> shopCarousels = Optional.ofNullable(
                shopCarouselMapper.selectShopCarouselAll());
        shopCarousels.ifPresent(e -> shopCarouselsJsonObject.put("shopCarousels", e));
        long count = PageHelper.count(() -> shopCarouselMapper.selectShopCarouselAll());
        shopCarouselsJsonObject.put("count", count);
        return shopCarouselsJsonObject;
    }
}
