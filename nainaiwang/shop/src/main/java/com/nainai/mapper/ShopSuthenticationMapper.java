package com.nainai.mapper;

import com.nainai.domain.ShopSuthentication;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopSuthenticationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopSuthentication record);

    int insertSelective(ShopSuthentication record);

    ShopSuthentication selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopSuthentication record);

    int updateByPrimaryKey(ShopSuthentication record);

    /**
     * 根据shopId查找店铺认证信息
     * @param shopId
     * @return
     */
    @Select("select * from shop_suthentication where shop_id=#{shopId} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "id_no", property = "idNo"),
            @Result(column = "qq_no", property = "qqNo"),
            @Result(column = "positive_id", property = "positiveId"),
            @Result(column = "back_id", property = "backId"),
            @Result(column = "business_license", property = "businessLicense"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSuthentication> selectShopSuthenticationShopId(String shopId);

    /**
     * 查找所有铺认证信息
     * @return
     */
    @Select("select * from shop_suthentication ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "id_no", property = "idNo"),
            @Result(column = "qq_no", property = "qqNo"),
            @Result(column = "positive_id", property = "positiveId"),
            @Result(column = "back_id", property = "backId"),
            @Result(column = "business_license", property = "businessLicense"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSuthentication> selectShopSuthenticationAll();

    /**
     * 根据店铺id与名称模糊查询铺认证信息
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_suthentication where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "id_no", property = "idNo"),
            @Result(column = "qq_no", property = "qqNo"),
            @Result(column = "positive_id", property = "positiveId"),
            @Result(column = "back_id", property = "backId"),
            @Result(column = "business_license", property = "businessLicense"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopSuthentication> selectShopSuthenticationShopIdAndName(String shopId, String name);
}