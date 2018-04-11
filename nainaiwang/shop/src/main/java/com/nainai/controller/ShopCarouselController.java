package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopCarousel;
import com.nainai.service.ProductOfferService;
import com.nainai.service.ShopCarouselService;
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
 * Created by haopeng yan on 2018/1/12 16:36.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/shopcarousel")
public class ShopCarouselController {
    @Autowired
    private ShopCarouselService shopCarouselService;
    @Autowired
    private ProductOfferService productOfferService;

    /**
     * 添加轮播图信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "添加轮播图信息", notes = "店铺上架添加轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "productsId", value = "商品编号"),
            @ApiImplicitParam(dataType = "String", name = "offerId", value = "报盘编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "轮播图名称"),
            @ApiImplicitParam(dataType = "String", name = "picture", value = "图片"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "图片路径"),
            @ApiImplicitParam(dataType = "String", name = "linkAddress", value = "链接地址"),
            @ApiImplicitParam(dataType = "boolean", name = "isLink", value = "是否链接"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopCarousel", method = RequestMethod.PUT)
    public Result insertShopCarousel(@RequestBody JSONObject jsonObject) {
        ShopCarousel shopCarousel = new ShopCarousel();

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

        shopCarousel.setId(UUIDGenerator.getUUID());
        shopCarousel.setShopId(shopId);
        shopCarousel.setProductsId(productsId);
        shopCarousel.setOfferId(offerId);
        shopCarousel.setName(name);
        shopCarousel.setPicture(picture);
        shopCarousel.setPicturePath(picturePath);
        shopCarousel.setLinkAddress(linkAddress);
        shopCarousel.setIsLink(isLink == true ? 1 : 0);
        shopCarousel.setIsShow(isShow == true ? 1 : 0);
        shopCarousel.setSort(sort);
        shopCarousel.setRemarks(remarks);
        shopCarousel.setCreateTime(TimeUtil.getDate());
        shopCarousel.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(
                shopCarouselService.insertShopCarouselse(shopCarousel));
    }

    /**
     * 修改轮播图信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据id修改轮播图信息", notes = "根据id修改轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "轮播图编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "productsId", value = "商品编号"),
            @ApiImplicitParam(dataType = "String", name = "offerId", value = "报盘编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "姓名"),
            @ApiImplicitParam(dataType = "String", name = "picture", value = "图片"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "图片路径"),
            @ApiImplicitParam(dataType = "String", name = "linkAddress", value = "链接地址"),
            @ApiImplicitParam(dataType = "boolean", name = "isLink", value = "是否链接"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopCarouselIdSelective", method = RequestMethod.PUT)
    public Result updateShopCarouselIdSelective(@RequestBody JSONObject jsonObject) {
        ShopCarousel shopCarousel = new ShopCarousel();

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

        shopCarousel.setId(id);
        shopCarousel.setShopId(shopId);
        shopCarousel.setProductsId(productsId);
        shopCarousel.setOfferId(offerId);
        shopCarousel.setName(name);
        shopCarousel.setPicture(picture);
        shopCarousel.setPicturePath(picturePath);
        shopCarousel.setLinkAddress(linkAddress);
        shopCarousel.setIsLink(isLink == true ? 1 : 0);
        shopCarousel.setIsShow(isShow == true ? 1 : 0);
        shopCarousel.setSort(sort);
        shopCarousel.setRemarks(remarks);
        shopCarousel.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(
                shopCarouselService.updateShopCarouselIdSelective(shopCarousel));
    }

    /**
     * 删除单个轮播图信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "删除单个轮播图信息", notes = "根据id删除单个轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "轮播图编号")
    })
    @RequestMapping(value = "/deleteShopCarouselId", method = RequestMethod.DELETE)
    public Result deleteShopCarouselId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopCarouselService.deleteShopCarouselId(id));
    }

    /**
     * 查询所有轮播图信息
     *
     * @return result
     */
    @ApiOperation(value = "查询所有轮播图信息", notes = "查询所有轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopCarouselAllPage", method = RequestMethod.POST)
    public Result selectShopCarouselAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopCarouselService.selectShopCarouselAllPage(pageNum,pageSize));
    }
    /**
     * 根据id查询轮播图信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据id查询轮播图信息", notes = "根据id查询轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "轮播图编号")
    })
    @RequestMapping(value = "/selectShopCarouselId", method = RequestMethod.POST)
    public Result selectShopCarouselId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopCarouselService.selectShopCarouselId(id));
    }
    /**
     * 查询店铺下的所有轮播图信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的所有轮播图信息", notes = "根据店铺id查询店铺下的所有轮播图信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是后台系统？")
    })
    @RequestMapping(value = "/selectShopCarouselShopId", method = RequestMethod.POST)
    public Result selectShopCarouselShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        return ResultGenerator.genSuccessResult(shopCarouselService.selectShopCarouselShopId(shopId,isBackgroundSystem));
    }

}
