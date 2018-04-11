package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.service.ProductsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/1/18 12:47.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    /**
     * 查询当前店铺下的商品信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询当前店铺下的商品信息", notes = "根据店铺编号查询当前店铺下的商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "pageSize", value = "每页显示量"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号")
    })
    @RequestMapping(value = "/selectProductsandOfferByShopId", method = RequestMethod.POST)
    public Result selectProductsandOfferByShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(productsService.selectProductsandOfferByShopIdPage(pageNum,pageSize,shopId));
    }

    /**
     * 查询所有商品信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询所有商品信息", notes = "查询所有商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectProductsAll", method = RequestMethod.POST)
    public Result selectProductsAll(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(productsService.selectProductsAllPage(pageNum,pageSize));
    }
}
