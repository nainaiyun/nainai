package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.service.OrderSellService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/1/22 23:16.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

@RestController
@RequestMapping(value = "/ordersell")
public class OrderSellController {
    @Autowired
    private OrderSellService orderSellService;
    /**
     * 根据店铺编号查询当前店铺下的商品订单信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询当前店铺下的订单信息", notes = "根据店铺编号查询当前店铺下的商品订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号")
    })
    @RequestMapping(value = "/selectOrderSellByShopIdPage", method = RequestMethod.POST)
    public Result selectProductOfferByShopIdPage(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(orderSellService.selectOrderSellByShopIdPage(pageNum, pageSize, shopId));
    }
    /**
     * 根据店铺编号以及订单状态查询当前店铺下的商品订单信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询当前店铺下的订单信息", notes = "根据店铺编号以及订单状态查询当前店铺下的商品订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "pageNum", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "pageSize", value = "每页显示量"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "contractStatus", value = "订单状态")
    })
    @RequestMapping(value = "/selectOrderSellByShopIdAndStatusPage", method = RequestMethod.POST)
    public Result selectOrderSellByShopIdAndStatusPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        int contractStatus = jsonObject.getInteger("contractStatus");
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(orderSellService.selectOrderSellByShopIdAndStatusPage(pageNum, pageSize, shopId,contractStatus));
    }

    /**
     * 根据订单状态统计订单数
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据订单状态统计订单数", notes = "根据订单状态统计订单数")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号")
    })
    @RequestMapping(value = "/selectOrderSellCount", method = RequestMethod.POST)
    public Result selectOrderSellCount(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(orderSellService.selectOrderSellCount(shopId));
    }


}
