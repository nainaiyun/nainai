package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ProductOffer;
import com.nainai.mapper.ProductOfferMapper;
import com.nainai.service.ProductOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/22 13:54.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "productOfferService")
public class ProductOfferServiceImpl implements ProductOfferService{
    @Autowired
    private ProductOfferMapper productOfferMapper;

    @Override
    public int insertProductOffer(ProductOffer productOffer) {
        return productOfferMapper.insert(productOffer);
    }

    @Override
    public int updateProductOfferByIdSelective(ProductOffer productOffer) {
        return productOfferMapper.updateByPrimaryKeySelective(productOffer);
    }

    @Override
    public int deleteProductOfferById(Integer id) {
        return productOfferMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectProductOfferId(Integer id) {
        JSONObject productOfferJsonObject = new JSONObject();
        Optional<ProductOffer> optionalProductOffer = Optional.ofNullable(productOfferMapper.selectByPrimaryKey(id));
        optionalProductOffer.ifPresent(e->productOfferJsonObject.put("productOffer",e));
        return productOfferJsonObject;
    }

    @Override
    public JSONObject selectProductOfferAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject productOffersJsonObject = new JSONObject();
        Optional<List<ProductOffer>> optionalProductOffers = Optional.ofNullable(productOfferMapper.selectProductOfferAll());
        optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        long count = PageHelper.count(()->productOfferMapper.selectProductOfferAll());
        productOffersJsonObject.put("count",count);
        return productOffersJsonObject;
    }

    @Override
    public JSONObject selectProductOfferAndSubordinateByShopIdPage(int pageNum, int pageSize, String shopId) {
        JSONObject productOffersJsonObject = new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        Optional<List<Map<String,String>>> optionalProductOffers = Optional.ofNullable(productOfferMapper.selectProductOfferAndSubordinateByShopId(shopId));
        optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        long count = PageHelper.count(()->productOfferMapper.selectProductOfferAndSubordinateByShopId(shopId));
        productOffersJsonObject.put("count",count);
        return productOffersJsonObject;
    }

    @Override
    public JSONObject selectProductOfferProNameByShopId(String shopId) {
        JSONObject productOffersJsonObject = new JSONObject();
        Optional<List<Map<String,String>>> optionalProductOffers = Optional.ofNullable(productOfferMapper.selectProductOfferProNameByShopId(shopId));
        optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        return productOffersJsonObject;
    }

    @Override
    public JSONObject selectProductOfferListingByShopId(String shopId, String proName, String classifyId, String navigationId, String moduleId) {
        JSONObject productOffersJsonObject = new JSONObject();
        if (classifyId.length()>0){
            Optional<List<Map<String,String>>> optionalProductOffers = Optional.ofNullable(
                    productOfferMapper.selectProductOfferListingByClassifyId(shopId,proName,classifyId));
            optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        } else
        if (navigationId.length()>0){
            Optional<List<Map<String,String>>> optionalProductOffers = Optional.ofNullable(
                    productOfferMapper.selectProductOfferListingByNavigationId(shopId,proName,navigationId));
            optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        } else
        if (moduleId.length()>0){
            Optional<List<Map<String,String>>> optionalProductOffers = Optional.ofNullable(
                    productOfferMapper.selectProductOfferListingByModuleId(shopId,proName,moduleId));
            optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        }else {
            Optional<List<Map<String,String>>> optionalProductOffers = Optional.ofNullable(
                    productOfferMapper.selectProductOfferListingByShopId(shopId,proName));
            optionalProductOffers.ifPresent(e->productOffersJsonObject.put("productOffers",e));
        }

        return productOffersJsonObject;
    }

    @Override
    public Map<String, Integer> selectProductIdByOfferId(Integer offerId) {
        Map<String, Integer> map = productOfferMapper.selectProductIdByOfferId(offerId);
        if (map.size() > 0) {
            return map;
        } else {
            Map<String, Integer> map2 = new HashMap<>(1);
            map2.put("product_id",0);
            return map2;
        }
    }
}
