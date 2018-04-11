package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.ShopService;
import com.nainai.mapper.ShopServiceMapper;
import com.nainai.service.ShopServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/15 00:08.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopServiceService")
public class ShopServiceServiceImpl implements ShopServiceService {
    @Autowired
    private ShopServiceMapper shopServiceMapper;
    @Override
    public int insertShopService(ShopService shopService) {
        return shopServiceMapper.insert(shopService);
    }

    @Override
    public int updateShopServiceIdSelective(ShopService shopService) {
        return shopServiceMapper.updateByPrimaryKeySelective(shopService);
    }

    @Override
    public int deleteShopServiceId(String id) {
        return shopServiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopServiceId(String id) {
        JSONObject shopServiceJsonObject = new JSONObject();
        Optional<ShopService> shopService = Optional.ofNullable(shopServiceMapper.selectByPrimaryKey(id));
        shopService.ifPresent(e -> shopServiceJsonObject.put("shopService",e));
        return shopServiceJsonObject;
    }

    @Override
    public JSONObject selectShopServiceShopId(String shopId) {
        JSONObject jsonObject = new JSONObject();
        Optional<List<ShopService>> optional = Optional.ofNullable(
                shopServiceMapper.selectShopServiceShopId(shopId));
        optional.ifPresent(e -> jsonObject.put("shopServices",e));
        return jsonObject;
    }

    @Override
    public JSONObject selectShopServiceAll() {
        JSONObject shopServicesJsonObject = new JSONObject();
        Optional<List<ShopService>> shopServices = Optional.ofNullable(shopServiceMapper.selectShopServiceAll());
        shopServices.ifPresent(e -> shopServicesJsonObject.put("shopServices",e));
        return shopServicesJsonObject;
    }

    @Override
    public JSONObject selectShopServiceAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        JSONObject shopServicesJsonObject = new JSONObject();
        Optional<List<ShopService>> shopServices = Optional.ofNullable(shopServiceMapper.selectShopServiceAll());
        shopServices.ifPresent(e -> shopServicesJsonObject.put("shopServices",e));
        long count = PageHelper.count(()->shopServiceMapper.selectShopServiceAll());
        shopServicesJsonObject.put("count",count);
        return shopServicesJsonObject;
    }
}
