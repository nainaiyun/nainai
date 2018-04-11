package com.nainai.mapper;

import com.nainai.domain.ShopClassify;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopClassifyMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopClassify record);

    int insertSelective(ShopClassify record);

    ShopClassify selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopClassify record);

    int updateByPrimaryKey(ShopClassify record);

    /**
     * 根据shopId查找分类信息
     * @param shopId
     * @return
     */
    @Select("select * from shop_classify where shop_id=#{shopId} and is_show=1 order by sort , create_time asc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopClassify> selectShopClassifyByShopId(String shopId);

    /**
     * 根据shopId查找分类信息：后台系统
     * @param shopId
     * @return
     */
    @Select("select * from shop_classify where shop_id=#{shopId} order by sort , create_time asc  ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopClassify> selectShopClassifyByShopIdBS(String shopId);
    /**
     * 查找所有分类信息
     * @return
     */
    @Select("select * from shop_classify order by create_time desc ")
    List<ShopClassify> selectShopClassifyAll();

    /**
     * 根据店铺id与名称模糊查询分类信息
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_classify where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%') order by sort , create_time asc ")
    List<ShopClassify> selectShopClassifyShopIdAndName(String shopId, String name);
}