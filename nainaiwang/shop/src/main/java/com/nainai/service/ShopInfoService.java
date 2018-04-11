package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.ShopInfo;

/**
 * Created by haopeng yan on 2018/1/10 10:33.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

public interface ShopInfoService {

    /**
     * 添加一条店铺信息,更新user表,添加店铺风格,添加店铺浏览量
     *
     * @param shopInfo
     * @return
     */
    int insertShopInfo(ShopInfo shopInfo);

    /**
     * 修改店铺信息所有字段
     *
     * @param shopInfo
     * @return
     */
    int updateShopInfoId(ShopInfo shopInfo);

    /**
     * 修改店铺信息部分字段
     *
     * @param shopInfo
     * @return
     */
    int updateShopInfoIdSelective(ShopInfo shopInfo);

    /**
     * 根据id删除店铺信息
     *
     * @param id
     * @return
     */
    int deleteShopInfoId(String id);

    /**
     * 根据id查找店铺信息
     *
     * @param id
     * @return
     */
    JSONObject selectShopInfoId(String id);

    /**
     * 根据userId查找店铺信息
     *
     * @param userId
     * @return
     */
    JSONObject selectShopInfoUserId(Integer userId);

    /**
     * 查找所有店铺信息
     *
     * @return
     */
    JSONObject selectShopInfoAll();

    /**
     * 分页查询店铺信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject selectShopInfoAllPage(int pageNum, int pageSize);

    /**
     * 分页查询店铺信息以及推广信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject selectShopnfoAndSpreadPage(int pageNum, int pageSize, String name);

    /**
     * 店铺统计信息
     *
     * @param id
     * @return
     */
    JSONObject selectShopnfoCensus(String id);
}
