package com.nainai.mapper;

import com.nainai.domain.ShopStyle;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopStyleMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopStyle record);

    int insertSelective(ShopStyle record);

    ShopStyle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopStyle record);

    int updateByPrimaryKey(ShopStyle record);

    /**
     * 根据shopId查找店铺风格
     * @param shopId
     * @return
     */
    @Select("select * from shop_style where shop_id=#{shopId} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopStyle> selectShopStyleShopId(String shopId);

    /**
     * 查找所有店铺风格
     * @return
     */
    @Select("select * from shop_style ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopStyle> selectShopStyleAll();

    /**
     * 根据店铺id与名称模糊查询店铺风格
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_style where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopStyle> selectShopStyleShopIdAndName(String shopId, String name);
}