package com.nainai.service;

import com.alibaba.fastjson.JSONObject;
import com.nainai.domain.Bid;

/**
 * Created by haopeng yan on 2018/1/10 16:31.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public interface BidService {
    /**
     * 添加一条招标信息
     *
     * @param bid
     * @return
     */
    int insertBid(Bid bid);

    /**
     * 更新招标信息表的全部字段
     *
     * @param bid
     * @return
     */
    int updateBidIdSelective(Bid bid);

    /**
     * 根据id删除一条招标信息
     *
     * @param id
     * @return
     */
    int deleteBidId(Integer id);

    /**
     * 根据id查询招标信息
     *
     * @param id
     * @return
     */
    JSONObject selectBidId(Integer id);

    /**
     * 根据用户编号查询改用户下所有的招标信息
     *
     * @param userId
     * @return
     */
    JSONObject selectBidUserId(Integer userId);

    /**
     * 查询所有的招标信息
     *
     * @return
     */
    JSONObject selectBidAll();

    /**
     * 分页查询所有的招标信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject selectBidAllPage(int pageNum, int pageSize);

}
