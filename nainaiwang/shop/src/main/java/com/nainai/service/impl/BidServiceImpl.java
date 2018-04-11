package com.nainai.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.Bid;
import com.nainai.mapper.BidMapper;
import com.nainai.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/10 17:54.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "bidService")
public class BidServiceImpl implements BidService {

    @Autowired
    private BidMapper bidMapper;

    @Override
    @CachePut(key = "#bid.id",cacheNames = "Bid")
    public int insertBid(Bid bid) {
        return bidMapper.insert(bid);
    }

    @Override
    @CachePut(key = "#Bid.id",cacheNames = "Bid")
    public int updateBidIdSelective(Bid bid) {
        return bidMapper.updateByPrimaryKeySelective(bid);
    }

    @Override
    @CacheEvict(cacheNames="Bid", key="#id")
    public int deleteBidId(Integer id) {
        return bidMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Cacheable(cacheNames = "Bid" ,unless="#result == null")
    public JSONObject selectBidId(Integer id) {
        JSONObject bidJsonObject = new JSONObject();
        Optional<Bid> bid = Optional.ofNullable(bidMapper.selectByPrimaryKey(id));
        bid.ifPresent(e -> bidJsonObject.put("bid",e));
        return bidJsonObject;
    }

    @Override
    @Cacheable(cacheNames = "Bid" ,unless="#result == null")
    public JSONObject selectBidUserId(Integer userId) {
        JSONObject bidJsonObject = new JSONObject();
        Optional<List<Bid>> bids = Optional.ofNullable(bidMapper.selectBidUserId(userId));
        bids.ifPresent(e->bidJsonObject.put("bid",e));
        return bidJsonObject;
    }

    @Override
    @Cacheable(cacheNames = "Bid" ,unless="#result == null")
    public JSONObject selectBidAll() {
        JSONObject bidjsonObject = new JSONObject();
        Optional<List<Bid>> bids = Optional.ofNullable(bidMapper.selectBidAll());
        bids.ifPresent(e->bidjsonObject.put("bids",e));
        return bidjsonObject;
    }

    @Override
    @Cacheable(cacheNames = "Bid" ,key = "#pageNum+':'+#pageSize",unless="#result == null")
    public JSONObject selectBidAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject bidjsonObject = new JSONObject();
        Optional<List<Bid>> bids = Optional.ofNullable(bidMapper.selectBidAll());
        bids.ifPresent(e->bidjsonObject.put("bids",e));
        long count = PageHelper.count(()->bidMapper.selectBidAll());
        bidjsonObject.put("count",count);
        return bidjsonObject;
    }
}
