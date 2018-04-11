package com.nainai.mapper;

import com.nainai.domain.ShopModule;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopModuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopModule record);

    int insertSelective(ShopModule record);

    ShopModule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopModule record);

    int updateByPrimaryKey(ShopModule record);

    /**
     * 根据shopId查找店铺模块信息
     * @param shopId
     * @return
     */
    @Select("select * from shop_module where shop_id=#{shopId} and is_show=1  order by sort, create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopModule> selectShopModuleShopId(String shopId);
    /**
     * 根据shopId查找店铺模块信息-后台系统
     * @param shopId
     * @return
     */
    @Select("select * from shop_module where shop_id=#{shopId} order by sort, create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopModule> selectShopModuleShopIdBS(String shopId);
    /**
     * 查找所有店铺模块信息
     * @return
     */
    @Select("select * from shop_module order by create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })

    List<ShopModule> selectShopModuleAll();

    /**
     * 根据店铺id与名称模糊查询店铺模块信息
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_module where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%') order by sort, create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopModule> selectShopModuleShopIdAndName(String shopId, String name);
}