package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopSuthentication;

/**
 * Created by haopeng yan on 2018/1/10 17:53.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopSuthenticationService {
    int insertShopSuthentication(ShopSuthentication shopSuthentication);

    int updateShopStyleIdSelective(ShopSuthentication shopSuthentication);

    int deleteShopSuthenticationId(String id);

    JSONObject selectShopSuthenticationId(String id);

    JSONObject selectShopSuthenticationShopId(String shopId);

    JSONObject selectShopSuthenticationAll();

    JSONObject selectShopSuthenticationAllPage(int pageNum, int pageSize);
}
