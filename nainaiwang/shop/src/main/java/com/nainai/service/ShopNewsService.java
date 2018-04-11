package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopNews;

/**
 * Created by haopeng yan on 2018/1/29 09:29.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopNewsService {
    int insertShopNews(ShopNews shopNews);

    int updateShopNewsIdSelective(ShopNews shopNews);

    int deleteShopNewsId(String id);

    JSONObject selectShopNewsId(String id);

    JSONObject selectShopNewsShopIdPage(int pageNum, int pageSize, String shopId, int isBackgroundSystem);

    JSONObject selectShopNewsAllPage(int pageNum, int pageSize);
}
