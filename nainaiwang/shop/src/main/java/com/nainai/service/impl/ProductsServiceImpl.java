package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.Products;
import com.nainai.mapper.ProductsMapper;
import com.nainai.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/11 13:56.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "productsService")
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsMapper productsMapper;
    @Override
    public int insertProducts(Products products) {
        return productsMapper.insert(products);
    }

    @Override
    public int updateProductsIdSelective(Products products) {
        return productsMapper.updateByPrimaryKeySelective(products);
    }

    @Override
    public int deleteProductsId(Integer id) {
        return productsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectProductsId(Integer id) {
        JSONObject productsJsonObject = new JSONObject();
        Optional<Products> product = Optional.ofNullable(productsMapper.selectByPrimaryKey(id));
        product.ifPresent(e->productsJsonObject.put("product",e));
        return productsJsonObject;
    }

    @Override
    public JSONObject selectProductsUserId(Integer userId) {
        JSONObject productsJsonObject = new JSONObject();
        Optional<List<Products>> products = Optional.ofNullable(productsMapper.selectProductsUserId(userId));
        products.ifPresent(e->productsJsonObject.put("products",e));
        return productsJsonObject;
    }

    @Override
    public JSONObject selectProductsAll() {
        JSONObject productsJsonObject = new JSONObject();
        Optional<List<Products>> products = Optional.ofNullable(productsMapper.selectProductsAll());
        products.ifPresent(e->productsJsonObject.put("products",e));
        return productsJsonObject;
    }

    @Override
    public JSONObject selectProductsAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject productsJsonObject = new JSONObject();
        Optional<List<Products>> products = Optional.ofNullable(productsMapper.selectProductsAll());
        products.ifPresent(e->productsJsonObject.put("products",e));
        long count = PageHelper.count(()->productsMapper.selectProductsAll());
        productsJsonObject.put("count",count);
        return productsJsonObject;
    }

    @Override
    public JSONObject selectProductsandOfferByShopIdPage(int pageNum,int pageSize,String shopId) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject productsJsonObject = new JSONObject();
        Optional<List<Map<String,String>>> products = Optional.ofNullable(productsMapper.selectProductsandOfferByShopId(shopId));
        products.ifPresent(e->productsJsonObject.put("products",e));
        long count = PageHelper.count(()->productsMapper.selectProductsandOfferByShopId(shopId));
        productsJsonObject.put("count",count);
        return productsJsonObject;
    }


}
