package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ProductOffer;

import java.util.Map;

/**
 * Created by haopeng yan on 2018/1/22 13:44.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ProductOfferService {
    int insertProductOffer(ProductOffer productOffer);

    int updateProductOfferByIdSelective(ProductOffer productOffer);

    int deleteProductOfferById(Integer id);

    JSONObject selectProductOfferId(Integer id);

    JSONObject selectProductOfferAllPage(int pageNum, int pageSize);

    JSONObject selectProductOfferAndSubordinateByShopIdPage(int pageNum, int pageSize, String shopId);

    JSONObject selectProductOfferProNameByShopId(String shopId);

    JSONObject selectProductOfferListingByShopId(String shopId, String proName, String classifyId, String navigationId, String moduleId);

    Map<String,Integer> selectProductIdByOfferId(Integer offerId);
}
