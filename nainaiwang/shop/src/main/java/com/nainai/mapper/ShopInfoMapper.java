package com.nainai.mapper;

import com.nainai.domain.ShopInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    ShopInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);

    /**
     * 根据userId查找店铺信息
     *
     * @param userId
     * @return
     */
    @Select("select * from shop_info where user_id=#{userId} order by sort , create_time asc ")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "main_project", property = "mainProject"),
            @Result(column = "main_supplies", property = "mainSupplies"),
            @Result(column = "operating_address", property = "operatingAddress"),
            @Result(column = "contact_address", property = "contactAddress"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ShopInfo selectShopInfoUserId(Integer userId);

    /**
     * 查找所有店铺信息
     *
     * @return
     */
    @Select("select * from shop_info order by sort , create_time asc ")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "main_project", property = "mainProject"),
            @Result(column = "main_supplies", property = "mainSupplies"),
            @Result(column = "operating_address", property = "operatingAddress"),
            @Result(column = "contact_address", property = "contactAddress"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopInfo> selectShopInfoAll();

    /**
     * 根据店铺名称模糊查询shop_info
     *
     * @param name
     * @return
     */
    @Select("select * from shop_info where name like  CONCAT('%',#{name},'%') order by sort , create_time asc ")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "main_project", property = "mainProject"),
            @Result(column = "main_supplies", property = "mainSupplies"),
            @Result(column = "operating_address", property = "operatingAddress"),
            @Result(column = "contact_address", property = "contactAddress"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopInfo> selectShopInfoName(String name) ;

}