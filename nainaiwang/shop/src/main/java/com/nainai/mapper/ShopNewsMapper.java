package com.nainai.mapper;

import com.nainai.domain.ShopNews;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShopNewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopNews record);

    int insertSelective(ShopNews record);

    ShopNews selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopNews record);

    int updateByPrimaryKey(ShopNews record);

    /**
     * 根据shopId查找店铺资讯
     * @param shopId
     * @return
     */
    @Select("select  id,shop_id, name,picture_path ,is_show,sort,remarks,create_time,update_time" +
            " from shop_news where shop_id=#{shopId} and is_show=1 order by sort asc ")
    List<Map<String, String>> selectShopNewsShopId(String shopId);

    /**
     * 根据shopId查找店铺资讯:后台系统
     * @param shopId
     * @return
     */
    @Select("select id,shop_id, name,picture_path ,is_show,sort,remarks,create_time,update_time" +
            " from shop_news where shop_id=#{shopId} order by sort asc ")
    List<Map<String, String>> selectShopNewsShopIdBS(String shopId);

    /**
     * 查找所有店铺资讯
     * @return
     */
    @Select("select * from shop_news ")
    List<ShopNews> selectShopNewsAll();

    /**
     * 根据店铺id与名称模糊查询店铺资讯
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_news where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')")
    List<ShopNews> selectShopNewsShopIdAndName(String shopId, String name);
}