package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopStyle;
import com.nainai.service.ShopStyleService;
import com.nainai.util.TimeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/1/17 17:23.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "shopstyle")
public class ShopStyleController {
    @Autowired
    private ShopStyleService shopStyleService;

    /**
     * 根据店铺id查询店铺所使用的风格
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺所使用的风格", notes = "根据店铺id查询店铺所使用的风格")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号")
    })
    @RequestMapping(value = "/selectShopStyleShopId", method = RequestMethod.POST)
    public Result selectShopStyleShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(shopStyleService.selectShopStyleShopId(shopId));
    }

    /**
     * 根据风格id修改店铺所使用的风格
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "修改店铺所使用的风格", notes = "根据风格id修改店铺所使用的风格")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "风格编号")
    })
    @RequestMapping(value = "/updateShopStyleIdSelective", method = RequestMethod.POST)
    public Result updateShopStyleId(@RequestBody() JSONObject jsonObject) {
        ShopStyle shopStyle = new ShopStyle();
        String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        shopStyle.setId(id);
        shopStyle.setName(name);
        shopStyle.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(shopStyleService.updateShopStyleIdSelective(shopStyle));
    }

    /**
     * 查询所有的风格
     *
     * @return result
     */
    @ApiOperation(value = "查询所有的风格", notes = "分页查询所有的风格")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopStyleAllPage", method = RequestMethod.POST)
    public Result selectShopStyleAllPage(@RequestBody() JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopStyleService.selectShopStyleAllPage(pageNum, pageSize));
    }


}
