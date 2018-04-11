package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopBrowse;

/**
 * Created by haopeng yan on 2018/1/10 17:46.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopBrowseService {
    int insertShopBrowse(ShopBrowse shopBrowse);

    int updateShopBrowseIdSelective(ShopBrowse shopBrowse);

    int deleteShopBrowseId(String id);

    JSONObject selectShopBrowseId(String id);

    JSONObject selectShopBrowseShopId(String shopId);

    JSONObject selectShopBrowseAll();

    JSONObject selectShopBrowseAllPage(int pageNum, int pageSize);
}
