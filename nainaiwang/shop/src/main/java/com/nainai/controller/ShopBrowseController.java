package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopBrowse;
import com.nainai.service.ShopBrowseService;
import com.nainai.util.TimeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haopeng yan on 2018/1/15 15:52.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

@RestController
@RequestMapping("/shopbrowse")
public class ShopBrowseController {

    @Autowired
    private ShopBrowseService shopBrowseService;

    /**
     * 增加浏览量
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "增加一个店铺浏览量", notes = "修改浏览量表，将浏览量信息+1")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "JSONObject", name = "jsonObject", value = "JSONObject对象", required = true)
    })
    @RequestMapping(value = "/updateShopBrowseIdSelective", method = RequestMethod.PUT)
    public Result updateShopBrowseIdSelective(@RequestBody JSONObject jsonObject) {
        /*ShopCarousel shopCarousel =JSONObject.toJavaObject(jsonObject,ShopCarousel.class);*/
        ShopBrowse shopBrowse = new ShopBrowse();
        String shopId = jsonObject.getString("shopId");
        JSONObject jsonObject1 = shopBrowseService.selectShopBrowseShopId(shopId);

        String id = jsonObject1.getJSONObject("shopBrowses").get("id").toString();
        Integer totalBrowsing = (Integer) jsonObject1.getJSONObject("shopBrowses").get("totalBrowsing");
        Integer monthlyBrowsing = (Integer) jsonObject1.getJSONObject("shopBrowses").get("monthlyBrowsing");

        shopBrowse.setId(id);
        shopBrowse.setTotalBrowsing(totalBrowsing+1);
        shopBrowse.setMonthlyBrowsing(monthlyBrowsing+1);
        shopBrowse.setUpdateTime(TimeUtil.getDate());
        return ResultGenerator.genSuccessResult(shopBrowseService.updateShopBrowseIdSelective(shopBrowse));
    }


    /**
     * 查询当前店铺下的浏览量信息
     *
     * @param
     * @return result
     */
    @ApiOperation(value = "查询当前店铺下的浏览量信息", notes = "根据店铺编号查询当前店铺下的浏览量信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号", required = true)
    })
    @RequestMapping(value = "/selectShopBrowseShopId", method = RequestMethod.POST)
    public Result selectShopBrowseShopId(@RequestParam(value = "shopId") String shopId) {
        return ResultGenerator.genSuccessResult(shopBrowseService.selectShopBrowseShopId(shopId));
    }
}
