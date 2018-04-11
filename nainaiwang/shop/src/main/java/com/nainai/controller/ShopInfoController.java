package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopInfo;
import com.nainai.service.ShopInfoService;
import com.nainai.util.TimeUtil;
import com.nainai.util.UUIDGenerator;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by haopeng yan on 2018/1/10 13:25.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping("/shopinfo")
public class ShopInfoController {
    @Autowired
    private ShopInfoService shopInfoService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 添加店铺信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "添加店铺信息", notes = "添加店铺信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "userId", value = "用户编号"),
            @ApiImplicitParam(dataType = "String", name = "logo", value = "店铺logo"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "店铺名称"),
            @ApiImplicitParam(dataType = "String", name = "synopsis", value = "店铺简介"),
            @ApiImplicitParam(dataType = "String", name = "mainProject", value = "主营项目"),
            @ApiImplicitParam(dataType = "String", name = "mainSupplies", value = "主要货源"),
            @ApiImplicitParam(dataType = "String", name = "introduce", value = "店铺介绍"),
            @ApiImplicitParam(dataType = "String", name = "operatingAddress", value = "所在地区"),
            @ApiImplicitParam(dataType = "String", name = "contactAddress", value = "联系地址"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopInfo", method = RequestMethod.PUT)
    public Result insertShopInfo(@RequestBody() JSONObject jsonObject) {
        ShopInfo shopInfo = new ShopInfo();

        Integer userId = jsonObject.getInteger("userId");
        String logo = jsonObject.getString("logo");
        String name = jsonObject.getString("name");
        String synopsis = jsonObject.getString("synopsis");
        String mainProject = jsonObject.getString("mainProject");
        String mainSupplies = jsonObject.getString("mainSupplies");
        String introduce = jsonObject.getString("introduce");
        /*boolean authentication = jsonObject.getBoolean("authentication");*/
        String operatingAddress = jsonObject.getString("operatingAddress");
        String contactAddress = jsonObject.getString("contactAddress");
        /*Integer sort = jsonObject.getInteger("sort");*/
        String remarks = jsonObject.getString("remarks");

        shopInfo.setId(UUIDGenerator.getUUID());
        shopInfo.setUserId(userId);
        shopInfo.setLogo(logo);
        shopInfo.setName(name);
        shopInfo.setSynopsis(synopsis);
        shopInfo.setMainProject(mainProject);
        shopInfo.setMainSupplies(mainSupplies);
        shopInfo.setIntroduce(introduce);
        shopInfo.setAuthentication(1);
        shopInfo.setOperatingAddress(operatingAddress);
        shopInfo.setContactAddress(contactAddress);
        shopInfo.setSort(new Random().nextInt(100000));
        shopInfo.setRemarks(remarks);
        shopInfo.setCreateTime(TimeUtil.getDate());
        shopInfo.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(shopInfoService.insertShopInfo(shopInfo));
    }

    /**
     * 根据id修改店铺信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "修改店铺信息全部字段", notes = "根据id修改店铺信息全部字段")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "店铺编号"),
            @ApiImplicitParam(dataType = "Integer", name = "userId", value = "用户编号"),
            @ApiImplicitParam(dataType = "String", name = "logo", value = "店铺logo"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "店铺名称"),
            @ApiImplicitParam(dataType = "String", name = "synopsis", value = "店铺简介"),
            @ApiImplicitParam(dataType = "String", name = "mainProject", value = "主营项目"),
            @ApiImplicitParam(dataType = "String", name = "mainSupplies", value = "主要货源"),
            @ApiImplicitParam(dataType = "String", name = "introduce", value = "店铺介绍"),
            @ApiImplicitParam(dataType = "String", name = "operatingAddress", value = "所在地区"),
            @ApiImplicitParam(dataType = "String", name = "contactAddress", value = "联系地址"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopInfoIdSelective", method = RequestMethod.PUT)
    public Result updateShopInfoIdSelective(@RequestBody JSONObject jsonObject) {
        ShopInfo shopInfo = new ShopInfo();

        String id = jsonObject.getString("id");
        /*Integer userId = jsonObject.getInteger("userId");*/
        String logo = jsonObject.getString("logo");
        String name = jsonObject.getString("name");
        String synopsis = jsonObject.getString("synopsis");
        String mainProject = jsonObject.getString("mainProject");
        String mainSupplies = jsonObject.getString("mainSupplies");
        String introduce = jsonObject.getString("introduce");
        /*boolean authentication = jsonObject.getBoolean("authentication");*/
        String operatingAddress = jsonObject.getString("operatingAddress");
        String contactAddress = jsonObject.getString("contactAddress");
        /*String sort = jsonObject.getString("sort");*/
        String remarks = jsonObject.getString("remarks");

        shopInfo.setId(id);
        /*shopInfo.setUserId(userId);*/
        shopInfo.setLogo(logo);
        shopInfo.setName(name);
        shopInfo.setSynopsis(synopsis);
        shopInfo.setMainProject(mainProject);
        shopInfo.setMainSupplies(mainSupplies);
        shopInfo.setIntroduce(introduce);
        /*shopInfo.setAuthentication(authentication==true ? 1:0);*/
        shopInfo.setAuthentication(1);
        shopInfo.setOperatingAddress(operatingAddress);
        shopInfo.setContactAddress(contactAddress);
        shopInfo.setRemarks(remarks);
        shopInfo.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(shopInfoService.updateShopInfoIdSelective(shopInfo));
    }

    /**
     * 根据id删除店铺信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据id删除店铺信息", notes = "根据id删除店铺信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "店铺编号")
    })
    @RequestMapping(value = "/deleteShopInfoId", method = RequestMethod.DELETE)
    public Result deleteShopInfoId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopInfoService.deleteShopInfoId(id));
    }

    /**
     * 根据店铺编号查询店铺信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据店铺编号查询店铺信息", notes = "根据店铺编号查询店铺信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "店铺的编号")
    })
    @RequestMapping(value = "/selectShopInfoId", method = RequestMethod.POST)
    public Result selectShopInfoId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopInfoService.selectShopInfoId(id));
    }

    /**
     * 查询所有店铺信息
     *
     * @return result
     */
    @ApiOperation(value = "查询所有店铺信息", notes = "查询所有店铺信息")
    @RequestMapping(value = "/selectShopInfoAll", method = RequestMethod.POST)
    public Result selectShopInfoAll() {
        return ResultGenerator.genSuccessResult(shopInfoService.selectShopInfoAll());
    }

    /**
     * 分页查询所有店铺信息
     *
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "分页查询所有店铺信息", notes = "分页查询所有店铺信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "查询第几页"),
            @ApiImplicitParam(dataType = "Integer", name = "pageSize", value = "每一页显示的列")
    })
    @RequestMapping(value = "/selectShopInfoAllPage", method = RequestMethod.POST)
    public Result selectShopnfoAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopInfoService.selectShopInfoAllPage(pageNum, pageSize));
    }

    /**
     * 分页查询店铺信息以及推广信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "分页查询店铺信息以及推广信息", notes = "分页查询店铺信息以及推广信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "查询第几页"),
            @ApiImplicitParam(dataType = "Integer", name = "pageSize", value = "每一页显示的列"),
            @ApiImplicitParam(dataType = "String", name = "Name", value = "店铺名称")
    })
    @RequestMapping(value = "/selectShopnfoAndSpreadPage", method = RequestMethod.POST)
    public Result selectShopnfoAndSpreadPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        String name = jsonObject.getString("name");
        String uname = request.getRemoteUser();
        return ResultGenerator.genSuccessResult(shopInfoService.selectShopnfoAndSpreadPage(pageNum, pageSize,name));
    }


    @ApiOperation(value = "店铺统计信息", notes = "根据店铺编号查询店铺统计信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "店铺id")
    })
    @RequestMapping(value = "/selectShopnfoCensus", method = RequestMethod.POST)
    public Result selectShopnfoCensus(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopInfoService.selectShopnfoCensus(id));
    }

}
