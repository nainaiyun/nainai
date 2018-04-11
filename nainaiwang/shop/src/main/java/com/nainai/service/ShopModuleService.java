package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopModule;

/**
 * Created by haopeng yan on 2018/1/10 17:49.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopModuleService {
    /**
     * 
     * @param shopModule
     * @return
     */
    int insertShopModule(ShopModule shopModule);

    int updateShopModuleIdSelective(ShopModule shopModule);

    int deleteShopModuleId(String id);

    JSONObject selectShopModuleId(String id);

    JSONObject selectShopModuleShopId(String shopId, int isBackgroundSystem);

    JSONObject selectShopModuleAll();

    JSONObject selectShopModuleAllPage(int pageNum, int pageSize);
}
