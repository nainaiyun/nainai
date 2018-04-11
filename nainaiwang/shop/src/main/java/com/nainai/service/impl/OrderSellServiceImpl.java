package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.OrderSell;
import com.nainai.mapper.OrderSellMapper;
import com.nainai.service.OrderSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/11 09:58.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "orderSellService")
public class OrderSellServiceImpl implements OrderSellService{
    @Autowired
    private OrderSellMapper orderSellMapper;

    @Override
    public int insertOrderSell(OrderSell orderSell) {
        return orderSellMapper.insert(orderSell);
    }

    @Override
    public int updateOrderSellIdSelective(OrderSell orderSell) {
        return orderSellMapper.updateByPrimaryKeySelective(orderSell);
    }

    @Override
    public int deleteOrderSellId(Integer id) {
        return orderSellMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectOrderSellId(Integer id) {
        JSONObject orderSellJsonObject = new JSONObject();
        Optional<OrderSell> orderSell = Optional.ofNullable(orderSellMapper.selectByPrimaryKey(id));
        orderSell.ifPresent(e -> orderSellJsonObject.put("orderSell",e));
        return orderSellJsonObject;
    }

    @Override
    public JSONObject selectOrderSellUserId(Integer userId) {
        JSONObject orderSellJsonObject = new JSONObject();
        Optional <List<OrderSell>> orderSells = Optional.ofNullable(orderSellMapper.selectOrderSellUserId(userId));
        orderSells.ifPresent(e -> orderSellJsonObject.put("orderSells",e));
        return orderSellJsonObject;
    }

    @Override
    public JSONObject selectOrderSellAll() {
        JSONObject orderSellJsonObject = new JSONObject();
        Optional <List<OrderSell>> orderSells = Optional.ofNullable(orderSellMapper.selectOrderSellAll());
        orderSells.ifPresent(e -> orderSellJsonObject.put("orderSells",e));
        return orderSellJsonObject;
    }

    @Override
    public JSONObject selectOrderSellAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject orderSellJsonObject = new JSONObject();
        Optional <List<OrderSell>> orderSells = Optional.ofNullable(orderSellMapper.selectOrderSellAll());
        orderSells.ifPresent(e -> orderSellJsonObject.put("orderSells",e));
        long count = PageHelper.count(()->orderSellMapper.selectOrderSellAll());
        orderSellJsonObject.put("count",count);
        return orderSellJsonObject;

    }

    @Override
    public JSONObject selectOrderSellByShopIdPage(int pageNum, int pageSize, String shopId) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject orderSellJsonObject = new JSONObject();
        Optional <List<OrderSell>> orderSells = Optional.ofNullable(orderSellMapper.selectOrderSellByShopIdPage(shopId));
        orderSells.ifPresent(e -> orderSellJsonObject.put("orderSells",e));
        long count = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdPage(shopId));
        orderSellJsonObject.put("count",count);
        return orderSellJsonObject;
    }

    @Override
    public JSONObject selectOrderSellByShopIdAndStatusPage(int pageNum, int pageSize, String shopId, int contractStatus) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject orderSellJsonObject = new JSONObject();
        Optional <List<OrderSell>> orderSells = Optional.ofNullable(orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId,contractStatus));
        orderSells.ifPresent(e -> orderSellJsonObject.put("orderSells",e));
        long count = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId,contractStatus));
        orderSellJsonObject.put("count",count);
        return orderSellJsonObject;
    }

    @Override
    public JSONObject selectOrderSellCount(String shopId) {
        JSONObject jsonObject = new JSONObject();
            long count0 = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId, 0));
            long count1 = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId, 4));
            long count2 = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId, 5));
            long count3 = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId, 6));
            long count4 = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId, 8));
            long count5 = PageHelper.count(()->orderSellMapper.selectOrderSellByShopIdAndStatusPage(shopId, 9));
            jsonObject.put("count0",count0);
            jsonObject.put("count1",count1);
            jsonObject.put("count2",count2);
            jsonObject.put("count3",count3);
            jsonObject.put("count4",count4);
            jsonObject.put("count5",count5);
        return jsonObject;
    }
}
