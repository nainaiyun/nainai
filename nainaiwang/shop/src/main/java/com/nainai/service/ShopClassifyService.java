package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopClassify;

/**
 * Created by haopeng yan on 2018/1/10 17:48.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopClassifyService {
    int insertShopClassify(ShopClassify shopClassify);

    int updateByPrimaryKeySelective(ShopClassify shopClassify);

    int deleteShopClassifyId(String id);

    JSONObject selectShopClassifyId(String id);

    JSONObject selectShopClassifyByShopId(String shopId, int isBackgroundSystem);

    JSONObject selectShopClassifyAll();

    JSONObject selectShopClassifyAllPage(int pageNum, int pageSize);
}
