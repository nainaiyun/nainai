package com.nainai.mapper;

import com.nainai.domain.ShopNavigation;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopNavigationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopNavigation record);

    int insertSelective(ShopNavigation record);

    ShopNavigation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopNavigation record);

    int updateByPrimaryKey(ShopNavigation record);
    /**
     * 根据shopId查找店铺导航栏
     * @param shopId
     * @return
     */
    @Select("select * from shop_navigation where shop_id=#{shopId} order by sort  , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationShopId(String shopId);

    /**
     * 查找所有店铺导航栏
     * @return
     */
    @Select("select * from shop_navigation ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationAll();

    /**
     * 根据店铺id与名称模糊查询店铺导航栏
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_navigation where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%') order by sort  , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationShopIdAndName(String shopId, String name);

    /**
     * 根据店铺id查询父级导航
     * @param shopId
     * @return
     */
    @Select("select * from shop_navigation where shop_id=#{shopId} and is_products=1 and is_show=1 order by sort  , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationParentShopId(String shopId);

    /**
     * 根据店铺id查询父级导航
     * @param shopId
     * @return
     */
    @Select("select * from shop_navigation where shop_id=#{shopId} and is_products=1 order by sort  , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationParentShopIdBS(String shopId);
    /**
     * 根据店铺id查询子级导航
     * @param shopId
     * @return
     */
    @Select("select * from shop_navigation where shop_id=#{shopId} and is_products=0 and is_show=1 order by sort  , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationSonShopId(String shopId);

    /**
     * 根据店铺id查询子级导航
     * @param shopId
     * @return
     */
    @Select("select * from shop_navigation where shop_id=#{shopId} and is_products=0 order by sort  , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "all_products", property = "allProducts"),
            @Result(column = "is_products", property = "isProducts"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNavigation> selectShopNavigationSonShopIdBS(String shopId);
}

