package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopModule;
import com.nainai.service.ShopModuleService;
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
 * Created by haopeng yan on 2018/1/15 17:27.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

@RestController
@RequestMapping("/shopmodule")
public class ShopModuleController {
    @Autowired
    private ShopModuleService shopModuleService;

    /**
     * 添加模块信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "添加模块信息", notes = "添加模块信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "姓名"),
            @ApiImplicitParam(dataType = "String", name = "picture", value = "图片"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopModule", method = RequestMethod.PUT)
    public Result insertShopModule(@RequestBody JSONObject jsonObject) {
        ShopModule shopModule = new ShopModule();

        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        String picture = jsonObject.getString("picture");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopModule.setId(UUIDGenerator.getUUID());
        shopModule.setShopId(shopId);
        shopModule.setName(name);
        shopModule.setPicturePath(picture);
        shopModule.setIsShow(isShow==true?1:0);
        shopModule.setSort(sort);
        shopModule.setRemarks(remarks);
        shopModule.setCreateTime(TimeUtil.getDate());
        shopModule.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopModuleService.insertShopModule(shopModule));
    }

    /**
     * 修改模块信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "修改模块信息", notes = "修改店铺模块信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "模块编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "姓名"),
            @ApiImplicitParam(dataType = "String", name = "picture", value = "图片"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopModuleIdSelective", method = RequestMethod.PUT)
    public Result updateShopModuleIdSelective(@RequestBody() JSONObject jsonObject) {
        ShopModule shopModule = new ShopModule();

        String id = jsonObject.getString("id");
        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        String picture = jsonObject.getString("picture");
        boolean isShow = jsonObject.getBoolean("isShow");
        int isShowNum = isShow==true?1:0;
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopModule.setId(id);
        shopModule.setShopId(shopId);
        shopModule.setName(name);
        shopModule.setPicturePath(picture);
        shopModule.setIsShow(isShowNum);
        shopModule.setSort(sort);
        shopModule.setRemarks(remarks);
        shopModule.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopModuleService.updateShopModuleIdSelective(shopModule));
    }

    /**
     * 根据模块编号删除模块
     * @param jsonObject
     * @return
     */
    @ApiOperation(value="根据模块编号删除该店铺下的模块", notes="根据模块编号删除该店铺下的模块")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "模块编号")
    })
    @RequestMapping(value = "/deleteShopModuleId",method = RequestMethod.DELETE)
    public Result deleteShopModuleId(@RequestBody JSONObject jsonObject){
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopModuleService.deleteShopModuleId(id));
    }

    /**
     * 根据编号查询该模块信息
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value="根据编号查询该店铺下的模块", notes="根据编号查询该店铺下的所有模块")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "模块编号")
    })
    @RequestMapping(value = "/selectShopModuleId",method = RequestMethod.POST)
    public Result selectShopModuleId(@RequestBody JSONObject jsonObject){
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopModuleService.selectShopModuleId(id));
    }
    /**
     * 根据店铺编号查询该店铺下的模块
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value="根据店铺编号查询该店铺下的模块", notes="根据店铺编号查询该店铺下的所有模块")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是否后台系统")
    })
    @RequestMapping(value = "/selectShopModuleShopId",method = RequestMethod.POST)
    public Result selectShopModuleShopId(@RequestBody JSONObject jsonObject){
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        return ResultGenerator.genSuccessResult(shopModuleService.selectShopModuleShopId(shopId,isBackgroundSystem));
    }
    /**
     * 查询所有的模块信息
     * @return result
     */
    @ApiOperation(value="查询所有的模块信息", notes="查询所有的模块信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopModuleAllPage",method = RequestMethod.POST)
    public Result selectShopModuleAllPage(@RequestBody JSONObject jsonObject){
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopModuleService.selectShopModuleAllPage(pageNum,pageSize));
    }

}
