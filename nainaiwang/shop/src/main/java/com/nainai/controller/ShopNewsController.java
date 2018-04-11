package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopNews;
import com.nainai.service.ShopNewsService;
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
 * Created by haopeng yan on 2018/1/29 09:28.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/shopnews")
public class ShopNewsController {
    @Autowired
    private ShopNewsService shopNewsService;
    /**
     * 添加资讯信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "添加资讯信息", notes = "添加资讯信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "资讯名称"),
            @ApiImplicitParam(dataType = "String", name = "content", value = "资讯内容"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "资讯图片"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopNews", method = RequestMethod.PUT)
    public Result insertShopNews(@RequestBody JSONObject jsonObject) {
        ShopNews shopNews = new ShopNews();

        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        String content = jsonObject.getString("content");
        String picturePath = jsonObject.getString("picturePath");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopNews.setId(UUIDGenerator.getUUID());
        shopNews.setShopId(shopId);
        shopNews.setName(name);
        shopNews.setContent(content);
        shopNews.setPicturePath(picturePath);
        shopNews.setIsShow(isShow == true ? 1 : 0);
        shopNews.setSort(sort);
        shopNews.setRemarks(remarks);
        shopNews.setCreateTime(TimeUtil.getDate());
        shopNews.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopNewsService.insertShopNews(shopNews));
    }

    /**
     * 修改资讯信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "修改资讯信息", notes = "根据id修改资讯信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "资讯名称"),
            @ApiImplicitParam(dataType = "String", name = "content", value = "资讯内容"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "资讯图片"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopNewsIdSelective", method = RequestMethod.PUT)
    public Result updateShopNewsIdSelective(@RequestBody JSONObject jsonObject) {
        ShopNews shopNews = new ShopNews();

        String id = jsonObject.getString("id");
        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        String content = jsonObject.getString("content");
        String picturePath = jsonObject.getString("picturePath");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopNews.setId(id);
        /*shopNews.setShopId(shopId);*/
        shopNews.setName(name);
        shopNews.setContent(content);
        shopNews.setPicturePath(picturePath);
        shopNews.setIsShow(isShow == true ? 1 : 0);
        shopNews.setSort(sort);
        shopNews.setRemarks(remarks);
        shopNews.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopNewsService.updateShopNewsIdSelective(shopNews));
    }

    /**
     * 删除单个资讯信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "删除单个资讯信息", notes = "根据id删除单个资讯信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "资讯编号"),
    })
    @RequestMapping(value = "/deleteShopNewsId", method = RequestMethod.DELETE)
    public Result deleteShopNewsId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopNewsService.deleteShopNewsId(id));
    }

    /**
     * 查询店铺下的所有资讯信息列表：不查询内容
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的所有资讯信息列表:不查询内容", notes = "根据店铺id查询店铺下的所有资讯信息：不查询内容")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是否后台系统"),
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(dataType = "Integer", name = "pageSize", value = "每页大小")
    })
    @RequestMapping(value = "/selectShopNewsShopIdPage", method = RequestMethod.POST)
    public Result selectShopNewsShopIdPage(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopNewsService.selectShopNewsShopIdPage(pageNum,pageSize,shopId,isBackgroundSystem));
    }
    /**
     * 根据资讯id查询资讯详情
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据资讯id查询资讯详情", notes = "根据资讯id查询资讯详情")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "资讯编号")
    })
    @RequestMapping(value = "/selectShopNewsId", method = RequestMethod.POST)
    public Result selectShopNewsId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopNewsService.selectShopNewsId(id));
    }
}
