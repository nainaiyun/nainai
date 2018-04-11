package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopNotice;
import com.nainai.service.ShopNoticeService;
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
 * Created by haopeng yan on 2018/1/17 14:01.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "shopnotice")
public class ShopNoticeController {
    @Autowired
    private ShopNoticeService shopNoticeService;

    /**
     * 添加公告信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "添加公告信息", notes = "添加公告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "公告名称"),
            @ApiImplicitParam(dataType = "String", name = "content", value = "公告内容"),
            @ApiImplicitParam(dataType = "String", name = "headPortrait", value = "公告图片"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopNotice", method = RequestMethod.PUT)
    public Result insertShopNotice(@RequestBody() JSONObject jsonObject) {
        ShopNotice shopNotice = new ShopNotice();

        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        String content = jsonObject.getString("content");
        String headPortrait = jsonObject.getString("headPortrait");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopNotice.setId(UUIDGenerator.getUUID());
        shopNotice.setShopId(shopId);
        shopNotice.setName(name);
        shopNotice.setContent(content);
        shopNotice.setHeadPortrait(headPortrait);
        shopNotice.setIsShow(isShow == true ? 1 : 0);
        shopNotice.setSort(sort);
        shopNotice.setRemarks(remarks);
        shopNotice.setCreateTime(TimeUtil.getDate());
        shopNotice.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopNoticeService.insertShopNotice(shopNotice));
    }

    /**
     * 删除单个公告信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "删除单个公告信息", notes = "根据id删除单个公告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "公告编号"),
    })
    @RequestMapping(value = "/deleteShopNoticeId", method = RequestMethod.DELETE)
    public Result deleteShopNoticeId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopNoticeService.deleteShopNoticeId(id));
    }

    /**
     * 查询所有公告信息列表
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询所有公告信息列表", notes = "查询所有公告信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopNoticeAllPage", method = RequestMethod.POST)
    public Result selectShopNoticeAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopNoticeService.selectShopNoticeAllPage(pageNum,pageSize));
    }

    /**
     * 查询店铺下的所有公告信息列表
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的所有公告信息列表:不查询内容", notes = "根据店铺id查询店铺下的所有公告信息:不查询内容")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "shopId"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是否后台系统"),
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(dataType = "Integer", name = "pageSize", value = "每页大小")
    })
    @RequestMapping(value = "/selectShopNoticeNameShopIdPage", method = RequestMethod.POST)
    public Result selectShopNoticeNameShopIdPage(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopNoticeService.selectShopNoticeNameShopIdPage(pageNum,pageSize,shopId,isBackgroundSystem));
    }

    /**
     * 查询店铺下的最近一个公告信息详情
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的最近一个公告信息", notes = "根据店铺id查询店铺下的所有公告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "shopId")
    })
    @RequestMapping(value = "/selectShopNoticeShopIdOne", method = RequestMethod.POST)
    public Result selectShopNoticeShopIdOne(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(shopNoticeService.selectShopNoticeShopIdOne(shopId));
    }

    /**
     * 根据id查看公告信息详情
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据id查看公告信息详情", notes = "根据店铺id查询公告信息详情")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "公告编号")
    })
    @RequestMapping(value = "/selectShopNoticeId", method = RequestMethod.POST)
    public Result selectShopNoticeId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopNoticeService.selectShopNoticeId(id));
    }
}
