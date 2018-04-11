package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopSpread;
import com.nainai.service.ProductOfferService;
import com.nainai.service.ShopSpreadService;
import com.nainai.util.TimeUtil;
import com.nainai.util.UUIDGenerator;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by haopeng yan on 2018/1/17 16:57.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/shopspread")
public class ShopSpreadController {
    @Autowired
    private ShopSpreadService shopSpreadService;

    @Autowired
    private ProductOfferService productOfferService;

    /**
     * 添加店铺推广信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "添加店铺推广信息", notes = "添加店铺推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "productsId", value = "商品编号"),
            @ApiImplicitParam(dataType = "String", name = "offerId", value = "报盘编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "推广名称"),
            @ApiImplicitParam(dataType = "String", name = "picture", value = "图片"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "图片路径"),
            @ApiImplicitParam(dataType = "String", name = "linkAddress", value = "链接地址"),
            @ApiImplicitParam(dataType = "boolean", name = "isLink", value = "是否链接"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopSpread", method = RequestMethod.PUT)
    public Result insertShopSpread(@RequestBody JSONObject jsonObject) {
        ShopSpread shopSpread = new ShopSpread();

        String shopId = jsonObject.getString("shopId");
        Integer offerId = jsonObject.getInteger("offerId");

        Map map = productOfferService.selectProductIdByOfferId(offerId);
        Integer productsId = (Integer) map.get("product_id");
        String name = jsonObject.getString("name");
        String picture = jsonObject.getString("picture");
        String picturePath = jsonObject.getString("picturePath");
        String linkAddress = jsonObject.getString("linkAddress");
        boolean isLink = jsonObject.getBoolean("isLink");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopSpread.setId(UUIDGenerator.getUUID());
        shopSpread.setShopId(shopId);
        shopSpread.setProductsId(productsId);
        shopSpread.setOfferId(offerId);
        shopSpread.setName(name);
        shopSpread.setPicture(picture);
        shopSpread.setPicturePath(picturePath);
        shopSpread.setLinkAddress(linkAddress);
        shopSpread.setIsLink(isLink == true ? 1 : 0);
        shopSpread.setIsShow(isShow == true ? 1 : 0);
        shopSpread.setSort(sort);
        shopSpread.setRemarks(remarks);
        shopSpread.setCreateTime(TimeUtil.getDate());
        shopSpread.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(
                shopSpreadService.insertShopSpread(shopSpread));
    }

    /**
     * 根据id修改店铺推广信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "修改店铺推广信息", notes = "根据id修改店铺推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "推广编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "productsId", value = "商品编号"),
            @ApiImplicitParam(dataType = "String", name = "offerId", value = "报盘编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "推广名称"),
            @ApiImplicitParam(dataType = "String", name = "picture", value = "图片"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "图片路径"),
            @ApiImplicitParam(dataType = "String", name = "linkAddress", value = "链接地址"),
            @ApiImplicitParam(dataType = "boolean", name = "isLink", value = "是否链接"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopSpreadIdSelective", method = RequestMethod.PUT)
    public Result updateShopSpreadIdSelective(@RequestBody JSONObject jsonObject) {
        ShopSpread shopSpread = new ShopSpread();

        String id = jsonObject.getString("id");
        String shopId = jsonObject.getString("shopId");
        Integer offerId = jsonObject.getInteger("offerId");
        Map map = productOfferService.selectProductIdByOfferId(offerId);
        Integer productsId = (Integer) map.get("product_id");
        String name = jsonObject.getString("name");
        String picture = jsonObject.getString("picture");
        String picturePath = jsonObject.getString("picturePath");
        String linkAddress = jsonObject.getString("linkAddress");
        boolean isLink = jsonObject.getBoolean("isLink");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopSpread.setId(id);
        shopSpread.setShopId(shopId);
        shopSpread.setProductsId(productsId);
        shopSpread.setOfferId(offerId);
        shopSpread.setName(name);
        shopSpread.setPicture(picture);
        shopSpread.setPicturePath(picturePath);
        shopSpread.setLinkAddress(linkAddress);
        shopSpread.setIsLink(isLink == true ? 1 : 0);
        shopSpread.setIsShow(isShow == true ? 1 : 0);
        shopSpread.setSort(sort);
        shopSpread.setRemarks(remarks);
        shopSpread.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(
                shopSpreadService.updateShopSpreadIdSelective(shopSpread));
    }

    /**
     * 根据id删除单个店铺推广信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "删除单个店铺推广信息", notes = "根据id删除单个店铺推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "推广编号")
    })
    @RequestMapping(value = "/deleteShopSpreadId", method = RequestMethod.DELETE)
    public Result deleteShopSpreadId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopSpreadService.deleteShopSpreadId(id));
    }

    /**
     * 查询所有店铺推广信息
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询所有店铺推广信息", notes = "查询所有店铺推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopSpreadAllPage", method = RequestMethod.POST)
    public Result selectShopSpreadAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopSpreadService.selectShopSpreadAllPage(pageNum, pageSize));
    }

    /**
     * 根据id查询店铺推广信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据id查询店铺推广信息", notes = "根据id查询店铺推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "店铺推广编号"),
    })
    @RequestMapping(value = "/selectShopSpreadeId", method = RequestMethod.POST)
    public Result selectShopSpreadeId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopSpreadService.selectShopSpreadeId(id));
    }

    /**
     * 根据店铺id查询店铺下的店铺推广信息+报盘名称
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的店铺推广信息+报盘名称", notes = "根据店铺id查询店铺下的店铺推广信息+报盘名称")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是否后台系统")
    })
    @RequestMapping(value = "/selectShopSpreadAndProNameShopId", method = RequestMethod.POST)
    public Result selectShopSpreadAndProNameShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        return ResultGenerator.genSuccessResult(shopSpreadService.selectShopSpreadAndProNameShopId(shopId,isBackgroundSystem));
    }

}
