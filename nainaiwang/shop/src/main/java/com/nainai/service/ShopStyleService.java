package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopStyle;

/**
 * Created by haopeng yan on 2018/1/10 17:52.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopStyleService {
    int insertShopStyle(ShopStyle shopStyle);

    int updateShopStyleIdSelective(ShopStyle shopStyle);

    int deleteShopStyleId(String id);

    JSONObject selectShopStyleId(String id);

    JSONObject selectShopStyleShopId(String shopId);

    JSONObject selectShopStyleAll();

    JSONObject selectShopStyleAllPage(int pageNum, int pageSize);
}
