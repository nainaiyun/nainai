package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.OrderSell;

/**
 * Created by haopeng yan on 2018/1/10 17:42.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface OrderSellService {
    /**
     * 插入一条订单信息
     * @param orderSell
     * @return
     */
    int insertOrderSell(OrderSell orderSell);

    /**
     * 根据id修改订单信息全部字段
     * @param orderSell
     * @return
     */
    int updateOrderSellIdSelective(OrderSell orderSell);

    /**
     * 根据id删除一条订单信息
     * @param id
     * @return
     */
    int deleteOrderSellId(Integer id);

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    JSONObject selectOrderSellId(Integer id);

    /**
     * 根据用户编号查询该用户的所有订单信息
     * @param userId
     * @return
     */
    JSONObject selectOrderSellUserId(Integer userId);

    /**
     * 查询所有的订单信息
     * @return
     */
    JSONObject selectOrderSellAll();

    /**
     * 分页查询所有的订单信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject selectOrderSellAllPage(int pageNum, int pageSize);

    /**
     * 分页查询店铺下的订单信息
     * @param pageNum
     * @param pageSize
     * @param shopId
     * @return
     */
    JSONObject selectOrderSellByShopIdPage(int pageNum, int pageSize, String shopId);


    JSONObject selectOrderSellByShopIdAndStatusPage(int pageNum, int pageSize, String shopId, int contractStatus);

    JSONObject selectOrderSellCount(String shopId);
}
