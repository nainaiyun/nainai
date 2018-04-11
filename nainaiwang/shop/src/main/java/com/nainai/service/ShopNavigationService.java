package com.nainai.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopNavigation;

/**
 * Created by haopeng yan on 2018/1/10 17:50.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopNavigationService {
    int insertShopNavigation(ShopNavigation shopNavigation);

    int updateShopNavigationIdSelective(ShopNavigation shopNavigation);

    int deleteShopNavigationId(String id);

    JSONObject selectShopNavigationId(String id);

    JSONArray selectShopNavigationShopId(String shopId, int isBackgroundSystem);

    JSONObject selectShopNavigationAll();

    JSONObject selectShopNavigationAllPage(int pageNum, int pageSize);

    JSONObject selectShopNavigationParentShopId(String shopId);
}
