package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopSpread;

/**
 * Created by haopeng yan on 2018/1/16 12:02.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopSpreadService  {

    int insertShopSpread(ShopSpread shopSpread);

    int updateShopSpreadIdSelective(ShopSpread shopSpread);

    int deleteShopSpreadId(String id);

    JSONObject selectShopSpreadeId(String id);

    JSONObject selectShopSpreadAndProNameShopId(String shopId, int isBackgroundSystem);

    JSONObject selectShopSpreadAll();

    JSONObject selectShopSpreadAllPage(int pageNum, int pageSize);
}
