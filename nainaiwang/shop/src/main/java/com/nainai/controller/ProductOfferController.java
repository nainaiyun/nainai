package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ProductOffer;
import com.nainai.service.ProductOfferService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haopeng yan on 2018/1/22 13:59.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/productoffer")
public class ProductOfferController {
    @Autowired
    private ProductOfferService productOfferService;

    /**
     * 根据id修改商品报盘信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "根据id修改商品报盘信息", notes = "根据报盘id修改商品报盘信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "id", value = "报盘编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "classifyId", value = "分类编号"),

            @ApiImplicitParam(dataType = "String", name = "moduleId", value = "模块编号"),
            @ApiImplicitParam(dataType = "String", name = "navigationId", value = "导航编号"),
    })
    @RequestMapping(value = "/updateProductOfferByIdSelective", method = RequestMethod.POST)
    public Result updateProductOfferByIdSelective(@RequestBody JSONObject jsonObject) {
        ProductOffer productOffer = new ProductOffer();
        Integer id = jsonObject.getInteger("id");
        String shopId = jsonObject.getString("shopId");
        String classifyId = jsonObject.getString("classifyId");
        String moduleId = jsonObject.getString("moduleId");
        String navigationId = jsonObject.getString("navigationId");

        productOffer.setId(id);
        productOffer.setShopId(shopId);
        productOffer.setClassifyId(classifyId);
        productOffer.setModuleId(moduleId);
        productOffer.setNavigationId(navigationId);

        return ResultGenerator.genSuccessResult(
                productOfferService.updateProductOfferByIdSelective(productOffer));
    }

    /**
     * 分页查询当前店铺下的商品报盘信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "分页查询当前店铺下的商品报盘信息+所属信息", notes = "分页根据店铺编号查询当前店铺下的商品报盘信息+所属信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号")
    })
    @RequestMapping(value = "/selectProductOfferAndSubordinateByShopIdPage", method = RequestMethod.POST)
    public Result selectProductOfferAndSubordinateByShopIdPage(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(productOfferService.selectProductOfferAndSubordinateByShopIdPage(pageNum, pageSize, shopId));
    }

    /**
     * 查询当前店铺下的商品报盘信息id+proName
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询当前店铺下的商品报盘信息id+商品名称（审核通过）", notes = "根据店铺编号查询当前店铺下的商品报盘信息id+proName")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号")
    })
    @RequestMapping(value = "/selectProductOfferProNameByShopId", method = RequestMethod.POST)
    public Result selectProductOfferProNameByShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(productOfferService.selectProductOfferProNameByShopId(shopId));
    }

    /**
     * 查询当前店铺下的商品报盘列表信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询当前店铺下的商品报盘列表信息", notes = "查询当前店铺下的商品报盘列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "proName", value = "报盘名称"),
            @ApiImplicitParam(dataType = "String", name = "moduleId", value = "所属模块编号"),
            @ApiImplicitParam(dataType = "String", name = "classifyId", value = "所属分类编号"),
            @ApiImplicitParam(dataType = "String", name = "navigationId", value = "所属导航编号")
    })
    @RequestMapping(value = "/selectProductOfferListingByShopId", method = RequestMethod.POST)
    public Result selectProductOfferListingByShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        String proName = jsonObject.getString("proName");
        String moduleId = jsonObject.getString("moduleId");
        String classifyId = jsonObject.getString("classifyId");
        String navigationId = jsonObject.getString("navigationId");
        return ResultGenerator.genSuccessResult(productOfferService.selectProductOfferListingByShopId(shopId,proName,classifyId,navigationId,moduleId));
    }
}
