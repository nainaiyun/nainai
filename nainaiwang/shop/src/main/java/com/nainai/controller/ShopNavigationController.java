package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopNavigation;
import com.nainai.service.ShopNavigationService;
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

/**
 * Created by haopeng yan on 2018/1/17 10:19.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/shopnavigation")
public class ShopNavigationController {
    @Autowired
    private ShopNavigationService shopNavigationService;

    /**
     * 添加导航信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "添加导航信息", notes = "添加导航信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "parentId", value = "父级编号"),
            @ApiImplicitParam(dataType = "String", name = "allProducts", value = "所有父级编号"),
            @ApiImplicitParam(dataType = "Integer", name = "isProducts", value = "是否父级编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "导航栏名称"),
            @ApiImplicitParam(dataType = "String", name = "linkAddress", value = "链接地址"),
            @ApiImplicitParam(dataType = "boolean", name = "isLink", value = "是否链接"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopNavigationParent", method = RequestMethod.PUT)
    public Result insertShopNavigationParent(@RequestBody JSONObject jsonObject) {
        ShopNavigation shopNavigation = new ShopNavigation();

        String shopId = jsonObject.getString("shopId");
        String parentId = jsonObject.getString("parentId");
        String allProducts = jsonObject.getString("allProducts");
        Integer isProducts = jsonObject.getInteger("isProducts");
        String name = jsonObject.getString("name");
        String linkAddress = jsonObject.getString("linkAddress");
        boolean isLink = jsonObject.getBoolean("isLink");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopNavigation.setId(UUIDGenerator.getUUID());
        shopNavigation.setShopId(shopId);
        shopNavigation.setParentId(parentId);
        shopNavigation.setAllProducts(allProducts);
        shopNavigation.setIsProducts(isProducts);
        shopNavigation.setName(name);
        shopNavigation.setLinkAddress(linkAddress);
        shopNavigation.setIsLink(isLink == true ? 1 : 0);
        shopNavigation.setIsShow(isShow == true ? 1 : 0);
        shopNavigation.setSort(sort);
        shopNavigation.setRemarks(remarks);
        shopNavigation.setCreateTime(TimeUtil.getDate());
        shopNavigation.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(
                shopNavigationService.insertShopNavigation(shopNavigation));
    }

    /**
     * 根据id修改导航信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据id修改导航信息", notes = "根据id修改导航信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "导航栏编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "导航栏名称"),
            @ApiImplicitParam(dataType = "String", name = "linkAddress", value = "链接地址"),
            @ApiImplicitParam(dataType = "boolean", name = "isLink", value = "是否链接"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopNavigationIdSelective", method = RequestMethod.PUT)
    public Result updateShopNavigationIdSelective(@RequestBody JSONObject jsonObject) {
        ShopNavigation shopNavigation = new ShopNavigation();

        String id = jsonObject.getString("id");
        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        String linkAddress = jsonObject.getString("linkAddress");
        boolean isLink = jsonObject.getBoolean("isLink");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopNavigation.setId(id);
        shopNavigation.setShopId(shopId);
        shopNavigation.setName(name);
        shopNavigation.setLinkAddress(linkAddress);
        shopNavigation.setIsLink(isLink == true ? 1 : 0);
        shopNavigation.setIsShow(isShow == true ? 1 : 0);
        shopNavigation.setSort(sort);
        shopNavigation.setRemarks(remarks);
        shopNavigation.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(
                shopNavigationService.updateShopNavigationIdSelective(shopNavigation));
    }

    /**
     * 根据id删除导航信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据id删除导航栏信息", notes = "根据id删除导航信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "导航编号")
    })
    @RequestMapping(value = "/deleteShopNavigationId", method = RequestMethod.DELETE)
    public Result deleteShopNavigationId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(
                shopNavigationService.deleteShopNavigationId(id));
    }

    /**
     * 分页查询所有导航信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "分页查询所有导航信息", notes = "分页查询所有导航信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopNavigationAllPage", method = RequestMethod.POST)
    public Result selectShopNavigationAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(
                shopNavigationService.selectShopNavigationAllPage(pageNum, pageSize));
    }

    /**
     * 查询父级导航信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询父级导航信息", notes = "根据店铺id查询父级导航信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
    })
    @RequestMapping(value = "/selectShopNavigationParentShopId", method = RequestMethod.POST)
    public Result selectShopNavigationParentShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(
                shopNavigationService.selectShopNavigationParentShopId(shopId));
    }

    /**
     * 查询店铺下的导航信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的导航信息", notes = "根据店铺id查询导航信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是否后台系统")
    })
    @RequestMapping(value = "/selectShopNavigationShopId", method = RequestMethod.POST)
    public Result selectShopNavigationShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        return ResultGenerator.genSuccessResult(
                shopNavigationService.selectShopNavigationShopId(shopId,isBackgroundSystem));
    }




}
