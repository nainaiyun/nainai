package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopCarousel;

/**
 * Created by haopeng yan on 2018/1/10 17:47.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopCarouselService {
    int insertShopCarouselse(ShopCarousel shopCarousel);

    int updateShopCarouselIdSelective(ShopCarousel shopCarousel);

    int deleteShopCarouselId(String id);

    JSONObject selectShopCarouselId(String id);

    JSONObject selectShopCarouselShopId(String shopId, int isBackgroundSystem);

    JSONObject selectShopCarouselAll();

    JSONObject selectShopCarouselAllPage(int pageNum, int pageSize);
}
