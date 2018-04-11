package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopService;

/**
 * Created by haopeng yan on 2018/1/10 17:52.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopServiceService {
    int insertShopService(ShopService shopService);

    int updateShopServiceIdSelective(ShopService shopService);

    int deleteShopServiceId(String id);

    JSONObject selectShopServiceId(String id);

    JSONObject selectShopServiceShopId(String shopId);

    JSONObject selectShopServiceAll();

    JSONObject selectShopServiceAllPage(int pageNum, int pageSize);
}
