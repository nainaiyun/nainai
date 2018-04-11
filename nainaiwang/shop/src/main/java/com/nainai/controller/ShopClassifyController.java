package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopClassify;
import com.nainai.service.ShopClassifyService;
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
 * Created by haopeng yan on 2018/1/11 15:32.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

@RestController
@RequestMapping("/shopclassify")
public class ShopClassifyController {

    @Autowired
    private ShopClassifyService shopClassifyService;

    /**
     * 添加分类信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "添加分类信息", notes = "添加分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "分类名称"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopClassify", method = RequestMethod.PUT)
    public Result insertShopClassify(@RequestBody JSONObject jsonObject) {
        ShopClassify shopClassify = new ShopClassify();

        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopClassify.setId(UUIDGenerator.getUUID());
        shopClassify.setShopId(shopId);
        shopClassify.setName(name);
        shopClassify.setIsShow(isShow == true ? 1 : 0);
        shopClassify.setSort(sort);
        shopClassify.setRemarks(remarks);
        shopClassify.setCreateTime(TimeUtil.getDate());
        shopClassify.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(shopClassifyService.insertShopClassify(shopClassify));
    }
    /**
     * 修改分类信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "修改分类信息", notes = "根据id修改所有字段的分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "分类编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "分类名称"),
            @ApiImplicitParam(dataType = "boolean", name = "isShow", value = "是否显示"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopClassifyIdSelective", method = RequestMethod.PUT)
    public Result updateShopClassifyIdSelective(@RequestBody JSONObject jsonObject) {
        ShopClassify shopClassify = new ShopClassify();

        String id = jsonObject.getString("id");
        String shopId = jsonObject.getString("shopId");
        String name = jsonObject.getString("name");
        boolean isShow = jsonObject.getBoolean("isShow");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        shopClassify.setId(id);
        shopClassify.setShopId(shopId);
        shopClassify.setName(name);
        shopClassify.setIsShow(isShow == true ? 1 : 0);
        shopClassify.setSort(sort);
        shopClassify.setRemarks(remarks);
        shopClassify.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopClassifyService.updateByPrimaryKeySelective(shopClassify));
    }
    /**
     * 根据id删除分类信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据id删除分类信息", notes = "根据id删除分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "分类编号")
    })
    @RequestMapping(value = "/deleteShopClassifyId", method = RequestMethod.DELETE)
    public Result deleteShopClassifyId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopClassifyService.deleteShopClassifyId(id));
    }
    /**
     * 查询店铺下的所有分类信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据店铺id查询所有分类信息", notes = "根据店铺id查询所有分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "shopId"),
            @ApiImplicitParam(dataType = "Integer", name = "isBackgroundSystem", value = "是否后台系统")
    })
    @RequestMapping(value = "/selectShopClassifyShopId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Result selectShopClassifyByShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int isBackgroundSystem = jsonObject.getInteger("isBackgroundSystem");
        return ResultGenerator.genSuccessResult(shopClassifyService.selectShopClassifyByShopId(shopId,isBackgroundSystem));
    }

    /**
     * 根据id查询分类信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据id查询分类信息", notes = "根据id查询分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "分类编号")

    })
    @RequestMapping(value = "/selectShopClassifyId", method = RequestMethod.POST )
    public Result selectShopClassifyId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopClassifyService.selectShopClassifyId(id));
    }

    /**
     * 查询所有分类信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询所有分类信息", notes = "查询所有分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopClassifyAllPage", method = RequestMethod.POST)
    public Result selectShopClassifyAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopClassifyService.selectShopClassifyAllPage(pageNum,pageSize));
    }

}
