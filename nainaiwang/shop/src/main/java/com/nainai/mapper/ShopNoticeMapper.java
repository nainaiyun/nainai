package com.nainai.mapper;

import com.nainai.domain.ShopNotice;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShopNoticeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopNotice record);

    int insertSelective(ShopNotice record);

    ShopNotice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopNotice record);

    int updateByPrimaryKey(ShopNotice record);

    /**
     * 根据shopId查找店铺公告:名称
     *
     * @param shopId
     * @return
     */
    @Select("select id,shop_id, name,head_portrait ,is_show,sort,remarks,create_time,update_time " +
            "from shop_notice where shop_id=#{shopId} order by sort asc , create_time desc ")
    List<Map<String, String>> selectShopNoticeNameShopId(String shopId);

    /**
     * 根据shopId查找店铺公告:名称-后台系统
     *
     * @param shopId
     * @return
     */
    @Select("select id,shop_id, name,head_portrait ,is_show,sort,remarks,create_time,update_time" +
            " from shop_notice where shop_id=#{shopId}  and is_show=1  order by sort asc , create_time desc")
    List<Map<String, String>> selectShopNoticeNameShopIdBS(String shopId);

    /**
     * 根据shopId查找店铺公告详情
     *
     * @param shopId
     * @return
     */
    @Select("select * from shop_notice where shop_id=#{shopId}  order by sort asc , create_time desc ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "head_portrait", property = "headPortrait"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNotice> selectShopNoticeShopId(String shopId);

    /**
     * 查找所有店铺公告
     *
     * @return
     */
    @Select("select * from shop_notice order by  create_time desc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "head_portrait", property = "headPortrait"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNotice> selectShopNoticeAll();

    /**
     * 根据店铺id与名称模糊查询店铺公告
     *
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_notice where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')  order by sort asc , create_time desc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "head_portrait", property = "headPortrait"),
            @Result(column = "is_show", property = "isShow"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopNotice> selectShopNoticeShopIdAndName(String shopId, String name);

}