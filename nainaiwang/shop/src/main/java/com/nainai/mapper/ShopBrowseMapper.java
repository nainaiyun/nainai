package com.nainai.mapper;

import com.nainai.domain.ShopBrowse;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopBrowseMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopBrowse record);

    int insertSelective(ShopBrowse record);

    ShopBrowse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopBrowse record);

    int updateByPrimaryKey(ShopBrowse record);

    /**
     * 根据shopId查找ShopBrowse
     * @param shopId
     * @return
     */
    @Select("select * from shop_browse where shop_id = #{shop_id} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "total_browsing", property = "totalBrowsing"),
            @Result(column = "monthly_browsing", property = "monthlyBrowsing"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ShopBrowse selectShopBrowseShopId(String shopId);

    /**
     * 根据shopId查找ShopBrowse,返回的是对象类型
     * @param shopId
     * @return
     */
    @Select("select * from shop_browse where shop_id = #{shop_id} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "total_browsing", property = "totalBrowsing"),
            @Result(column = "monthly_browsing", property = "monthlyBrowsing"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ShopBrowse selectShopBrowseShopIdSB(String shopId);

    /**
     * 查找所有ShopBrowse
     * @return
     */
    @Select("select * from shop_browse ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "total_browsing", property = "totalBrowsing"),
            @Result(column = "monthly_browsing", property = "monthlyBrowsing"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopBrowse> selectShopBrowseAll();

    /**
     * 根据店铺id与名称模糊查询
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_browse where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "total_browsing", property = "totalBrowsing"),
            @Result(column = "monthly_browsing", property = "monthlyBrowsing"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopBrowse> selectShopBrowseShopIdAndName(String shopId, String name);
}