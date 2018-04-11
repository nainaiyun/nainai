package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopNotice;

/**
 * Created by haopeng yan on 2018/1/10 17:52.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ShopNoticeService {
    int insertShopNotice(ShopNotice shopNotice);

    int updateShopNoticeIdSelective(ShopNotice shopNotice);

    int deleteShopNoticeId(String id);

    JSONObject selectShopNoticeId(String id);

    JSONObject selectShopNoticeNameShopIdPage(int pageNum, int pageSize, String shopId, int isBackgroundSystem);

    JSONObject selectShopNoticeShopIdOne(String shopId);

    JSONObject selectShopNoticeAll();

    JSONObject selectShopNoticeAllPage(int pageNum, int pageSize);
}
