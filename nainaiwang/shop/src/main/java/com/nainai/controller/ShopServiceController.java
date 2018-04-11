package com.nainai.controller;

import com.alibaba.fastjson.JSONObject;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.domain.ShopService;
import com.nainai.service.ShopServiceService;
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
 * Created by haopeng yan on 2018/1/17 15:14.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@RestController
@RequestMapping(value = "/shopservice")
public class ShopServiceController {
    @Autowired
    private ShopServiceService shopServiceService;
    /**
     * 添加客服信息至某个店铺
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "添加客服信息至某个店铺", notes = "添加客服信息至某个店铺")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "nickname", value = "昵称"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "姓名"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "图片路径"),
            @ApiImplicitParam(dataType = "String", name = "officePhone", value = "单位号码"),
            @ApiImplicitParam(dataType = "String", name = "mobilePhone", value = "手机号码"),
            @ApiImplicitParam(dataType = "String", name = "qqNo", value = "QQ号码"),
            @ApiImplicitParam(dataType = "String", name = "email", value = "邮箱"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/insertShopService", method = RequestMethod.PUT)
    public Result insertShopService(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        String nickname = jsonObject.getString("nickname");
        String name = jsonObject.getString("name");
        String picturePath = jsonObject.getString("picturePath");
        String officePhone = jsonObject.getString("officePhone");
        String mobilePhone = jsonObject.getString("mobilePhone");
        String qqNo = jsonObject.getString("qqNo");
        String email = jsonObject.getString("email");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        ShopService shopService = new ShopService();
        shopService.setId(UUIDGenerator.getUUID());
        shopService.setShopId(shopId);
        shopService.setNickname(nickname);
        shopService.setName(name);
        shopService.setPicturePath(picturePath);
        shopService.setOfficePhone(officePhone);
        shopService.setMobilePhone(mobilePhone);
        shopService.setQqNo(qqNo);
        shopService.setEmail(email);
        shopService.setSort(sort);
        shopService.setRemarks(remarks);
        shopService.setCreateTime(TimeUtil.getDate());
        shopService.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopServiceService.insertShopService(shopService));
    }

    /**
     * 根据id修改客服的信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "修改客服信息", notes = "根据id修改客服的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "客服编号"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "店铺编号"),
            @ApiImplicitParam(dataType = "String", name = "nickname", value = "昵称"),
            @ApiImplicitParam(dataType = "String", name = "name", value = "姓名"),
            @ApiImplicitParam(dataType = "String", name = "picturePath", value = "图片路径"),
            @ApiImplicitParam(dataType = "String", name = "officePhone", value = "单位号码"),
            @ApiImplicitParam(dataType = "String", name = "mobilePhone", value = "手机号码"),
            @ApiImplicitParam(dataType = "String", name = "qqNo", value = "QQ号码"),
            @ApiImplicitParam(dataType = "String", name = "email", value = "邮箱"),
            @ApiImplicitParam(dataType = "Integer", name = "sort", value = "排序"),
            @ApiImplicitParam(dataType = "String", name = "remarks", value = "备注")
    })
    @RequestMapping(value = "/updateShopServiceIdSelective", method = RequestMethod.PUT)
    public Result updateShopServiceIdSelective(@RequestBody() JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        String shopId = jsonObject.getString("shopId");
        String nickname = jsonObject.getString("nickname");
        String name = jsonObject.getString("name");
        String picturePath = jsonObject.getString("picturePath");
        String officePhone = jsonObject.getString("officePhone");
        String mobilePhone = jsonObject.getString("mobilePhone");
        String qqNo = jsonObject.getString("qqNo");
        String email = jsonObject.getString("email");
        Integer sort = jsonObject.getInteger("sort");
        String remarks = jsonObject.getString("remarks");

        ShopService shopService = new ShopService();
        shopService.setId(id);
        shopService.setShopId(shopId);
        shopService.setNickname(nickname);
        shopService.setName(name);
        shopService.setPicturePath(picturePath);
        shopService.setOfficePhone(officePhone);
        shopService.setMobilePhone(mobilePhone);
        shopService.setQqNo(qqNo);
        shopService.setEmail(email);
        shopService.setSort(sort);
        shopService.setRemarks(remarks);
        shopService.setUpdateTime(TimeUtil.getDate());

        return ResultGenerator.genSuccessResult(shopServiceService.updateShopServiceIdSelective(shopService));
    }

    /**
     * 根据id删除客服信息
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "删除客服信息", notes = "根据id删除客服信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "客服编号")
    })
    @RequestMapping(value = "/deleteShopServiceId", method = RequestMethod.DELETE)
    public Result deleteShopServiceId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopServiceService.deleteShopServiceId(id));
    }

    /**
     * 查询所有客服信息
     *
     * @return result
     */
    @ApiOperation(value = "查询所有客服信息", notes = "查询所有客服信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "第几页"),
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "每页显示量")
    })
    @RequestMapping(value = "/selectShopServiceAllPage", method = RequestMethod.POST)
    public Result selectShopServiceAllPage(@RequestBody JSONObject jsonObject) {
        int pageNum = jsonObject.getInteger("pageNum");
        int pageSize = jsonObject.getInteger("pageSize");
        return ResultGenerator.genSuccessResult(shopServiceService.selectShopServiceAllPage(pageNum,pageSize));
    }

    /**
     * 根据客服编号查询客服信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "根据客服编号查询客服信息", notes = "根据客服编号查询客服信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "客服编号")
    })
    @RequestMapping(value = "/selectShopServiceId", method = RequestMethod.POST)
    public Result selectShopServiceId(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        return ResultGenerator.genSuccessResult(shopServiceService.selectShopServiceId(id));
    }
    /**
     * 查询店铺下的所有客服信息
     *
     * @param jsonObject
     * @return result
     */
    @ApiOperation(value = "查询店铺下的所有客服信息", notes = "根据店铺id查询店铺下的所有客服信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "shopId", value = "shopId")
    })
    @RequestMapping(value = "/selectShopServiceShopId", method = RequestMethod.POST)
    public Result selectShopServiceShopId(@RequestBody JSONObject jsonObject) {
        String shopId = jsonObject.getString("shopId");
        return ResultGenerator.genSuccessResult(shopServiceService.selectShopServiceShopId(shopId));
    }

}
