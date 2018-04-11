package com.nainai.mapper;

import com.nainai.domain.ShopService;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopServiceMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopService record);

    int insertSelective(ShopService record);

    ShopService selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopService record);

    int updateByPrimaryKey(ShopService record);

    /**
     * 根据shopId查找店铺客服
     * @param shopId
     * @return
     */
    @Select("select * from shop_service where shop_id=#{shopId} order by sort,create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "office_phone", property = "officePhone"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "qq_no", property = "qqNo"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopService> selectShopServiceShopId(String shopId);

    /**
     * 查找所有店铺客服
     * @return
     */
    @Select("select * from shop_service order by create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "office_phone", property = "officePhone"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "qq_no", property = "qqNo"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopService> selectShopServiceAll();
    /**
     * 根据店铺id与名称模糊查询店铺客服
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_service where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%') order by sort,create_time asc")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "picture_path", property = "picturePath"),
            @Result(column = "office_phone", property = "officePhone"),
            @Result(column = "mobile_phone", property = "mobilePhone"),
            @Result(column = "qq_no", property = "qqNo"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ShopService> selectShopServiceShopIdAndName(String shopId, String name);
}