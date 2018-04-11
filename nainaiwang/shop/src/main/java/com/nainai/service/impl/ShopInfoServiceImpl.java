package com.nainai.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.nainai.domain.*;
import com.nainai.mapper.*;
import com.nainai.service.ShopInfoService;
import com.nainai.util.TimeUtil;
import com.nainai.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haopeng yan on 2018/1/10 13:21.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Service(value = "shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {
    @Autowired
    private ShopInfoMapper shopInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopStyleMapper shopStyleMapper;
    @Autowired
    private ShopBrowseMapper shopBrowseMapper;
    @Autowired
    private ShopSpreadMapper shopSpreadMapper;
    @Autowired
    private OrderSellMapper orderSellMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertShopInfo(ShopInfo shopInfo) {
        Integer userId = shopInfo.getUserId();
        User user = new User();
        user.setId(userId);
        user.setShopId(shopInfo.getId());
        /*更新user表中的shopId字段*/
        userMapper.updateByPrimaryKeySelective(user);
        /*添加店铺风格*/
        ShopStyle shopStyle = new ShopStyle();
        shopStyle.setId(UUIDGenerator.getUUID());
        shopStyle.setName(shopInfo.getName());
        shopStyle.setShopId(shopInfo.getId());
        shopStyle.setRemarks(shopInfo.getName() + "的店铺风格");
        shopStyle.setCreateTime(TimeUtil.getDate());
        shopStyle.setUpdateTime(TimeUtil.getDate());
        shopStyleMapper.insert(shopStyle);
        /*添加浏览量*/
        ShopBrowse shopBrowse = new ShopBrowse();
        shopBrowse.setId(UUIDGenerator.getUUID());
        shopBrowse.setName(shopInfo.getName());
        shopBrowse.setShopId(shopInfo.getId());
        shopBrowse.setTotalBrowsing(0);
        shopBrowse.setMonthlyBrowsing(0);
        shopBrowse.setRemarks(shopInfo.getName() + "的浏览量");
        shopBrowse.setCreateTime(TimeUtil.getDate());
        shopBrowse.setUpdateTime(TimeUtil.getDate());
        shopBrowseMapper.insert(shopBrowse);
        return shopInfoMapper.insert(shopInfo);
    }

    @Override
    public int updateShopInfoId(ShopInfo shopInfo) {
        return shopInfoMapper.updateByPrimaryKey(shopInfo);
    }

    @Override
    public int updateShopInfoIdSelective(ShopInfo shopInfo) {
        return shopInfoMapper.updateByPrimaryKeySelective(shopInfo);
    }

    @Override
    public int deleteShopInfoId(String id) {
        return shopInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JSONObject selectShopInfoId(String id) {
        JSONObject shopInfoJsonObject = new JSONObject();
        Optional<ShopInfo> shopInfo = Optional.ofNullable(shopInfoMapper.selectByPrimaryKey(id));
        shopInfo.ifPresent(e -> shopInfoJsonObject.put("shopInfo", e));
        return shopInfoJsonObject;
    }




    @Override
    public JSONObject selectShopInfoUserId(Integer userId) {
        JSONObject shopInfoJsonObject = new JSONObject();
        Optional<ShopInfo> shopInfo = Optional.ofNullable(shopInfoMapper.selectShopInfoUserId(userId));
        shopInfo.ifPresent(e -> shopInfoJsonObject.put("shopInfo", e));

        return shopInfoJsonObject;
    }

    @Override
    public JSONObject selectShopInfoAll() {
        JSONObject shopInfoJsonObject = new JSONObject();
        Optional<List<ShopInfo>> shopInfos = Optional.ofNullable(shopInfoMapper.selectShopInfoAll());
        shopInfos.ifPresent(e -> shopInfoJsonObject.put("shopInfos", e));
        return shopInfoJsonObject;
    }

    @Override
    public JSONObject selectShopInfoAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject shopInfoJsonObject = new JSONObject();
        Optional<List<ShopInfo>> shopInfos = Optional.ofNullable(shopInfoMapper.selectShopInfoAll());
        shopInfos.ifPresent(e -> shopInfoJsonObject.put("shopInfos", e));

        long count = PageHelper.count(()->shopInfoMapper.selectShopInfoAll());
        shopInfoJsonObject.put("count",count);
        return shopInfoJsonObject;
    }

    @Override
    public JSONObject selectShopnfoAndSpreadPage(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        JSONObject shopInfoJsonObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBufferTo = new StringBuffer();
        stringBufferTo.append("[");
        Optional<List<ShopInfo>> shopInfos = Optional.ofNullable(shopInfoMapper.selectShopInfoName(name));
        shopInfos.ifPresent(e -> {
            e.forEach(f -> {
                        shopInfoJsonObject.put("shopInfos", f);
                        Optional<List<ShopSpread>> shopSpreads = Optional.ofNullable(shopSpreadMapper.selectShopSpreadPicturePathByShopId(f.getId()));
                        shopSpreads.ifPresent(g -> shopInfoJsonObject.put("shopSpreads", g));
                        stringBuffer.append(shopInfoJsonObject);
                        stringBuffer.append(",");
                    }
            );
        });
        if (stringBuffer.length()>0){
            stringBufferTo.append(stringBuffer.substring(0, stringBuffer.length() - 1));
        }
        stringBufferTo.append("]");
        
        JSONArray myJsonArray = JSONArray.parseArray(stringBufferTo.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("selectShopnfoAndSpread",myJsonArray);

        long count = PageHelper.count(()->shopInfoMapper.selectShopInfoName(name));
        jsonObject.put("count",count);

        return jsonObject;
    }

    @Override
    public JSONObject selectShopnfoCensus(String id) {

        JSONObject jsonObject = new JSONObject();
        Map map = new HashMap(10);
        Optional<ShopInfo> optionalShopInfo = Optional.ofNullable(shopInfoMapper.selectByPrimaryKey(id));

        optionalShopInfo.ifPresent(e->{
            Optional<Map<String ,String>> optionalMap = Optional.ofNullable(userMapper.selectAccount(e.getUserId()));
            optionalMap.ifPresent(f->jsonObject.put("money",f));
        });

        /*获取本月订单总额*/
        Optional<Map<String,String>> optionalMap = Optional.ofNullable(orderSellMapper.selectAmount(id));
        optionalMap.ifPresent(e->jsonObject.put("orderAll",e));

        /*获取本月支付订单总额*/
        Optional<Map<String,String>> optionalPayMap = Optional.ofNullable(orderSellMapper.selectPayAmount(id,8));
        optionalPayMap.ifPresent(e->jsonObject.put("orderPay",e));

        /*获取本月支付买家数量*/
        Optional<Map<String,String>> optionalPayCountMap = Optional.ofNullable(orderSellMapper.selectPayCount(id,8));
        optionalPayCountMap.ifPresent(e->jsonObject.put("orderCount",e));

        /*获取店铺浏览量*/
        Optional<ShopBrowse> optionalShopBrowse = Optional.ofNullable(shopBrowseMapper.selectShopBrowseShopId(id));
        optionalShopBrowse.ifPresent(e->jsonObject.put("optionalShopBrowse",e));

        return jsonObject;
    }

}
