package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.Products;

/**
 * Created by haopeng yan on 2018/1/10 17:45.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface ProductsService {
    int insertProducts(Products products);

    int updateProductsIdSelective(Products products);

    int deleteProductsId(Integer id);

    JSONObject selectProductsId(Integer id);

    JSONObject selectProductsUserId(Integer userId);

    JSONObject selectProductsAll();

    JSONObject selectProductsAllPage(int pageNum, int pageSize);

    JSONObject selectProductsandOfferByShopIdPage(int pageNum, int pageSize, String shopId);
}
