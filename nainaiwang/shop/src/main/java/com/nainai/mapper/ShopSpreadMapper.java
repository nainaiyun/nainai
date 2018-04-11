package com.nainai.mapper;

import com.nainai.domain.ShopSpread;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShopSpreadMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopSpread record);

    int insertSelective(ShopSpread record);

    ShopSpread selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopSpread record);

    int updateByPrimaryKey(ShopSpread record);

    /**
     * 根据shopId查找店铺推广
     *
     * @param shopId
     * @return list
     */
    @Select("select * from shop_spread where shop_id=#{shopId} order by sort,create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "products_id", property = "productsId"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSpread> selectShopSpreadShopId(String shopId);

    /**
     * 根据shopId查找店铺推广及报盘名称
     *
     * @param shopId
     * @return map
     */
    @Select("select s.* ,p.p.name 'products_name' from shop_spread s left join products p on s.products_id = o.id " +
            " where s.shop_id = #{shopId} and is_show=1 order by sort,create_time asc")
    List<Map<String, String>> selectShopSpreadAndProNameShopId(String shopId);

    /**
     * 根据shopId查找店铺推广及报盘名称-后台系统
     *
     * @param shopId
     * @return map
     */
    @Select("select s.* ,p.name 'products_name' from shop_spread s left join products p on s.products_id = p.id " +
            " where s.shop_id = #{shopId}  order by sort,create_time asc")
    List<Map<String, String>> selectShopSpreadAndProNameShopIdBS(String shopId);

    /**
     * 根据店铺id查询推广展示信息
     *
     * @param shopId
     * @return
     */
    @Select("select * from shop_spread where shop_id=#{shopId} and is_show=1 order by sort,create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "products_id", property = "productsId"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSpread> selectShopSpreadPicturePathByShopId(String shopId);

    /**
     * 查找所有店铺推广
     *
     * @return
     */
    @Select("select * from shop_spread order by sort,create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "products_id", property = "productsId"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSpread> selectShopSpreadAll();

    /**
     * 根据店铺id与名称模糊查询店铺推广
     *
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_spread where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%') order by sort,create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "products_id", property = "productsId"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "link_address", property = "linkAddress"),
            @Result(column = "is_link", property = "isLink"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSpread> selectShopSpreadShopIdAndName(String shopId, String name);
}