package com.nainai.mapper;

import com.nainai.domain.ShopCarousel;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShopCarouselMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCarousel record);

    int insertSelective(ShopCarousel record);

    ShopCarousel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCarousel record);

    int updateByPrimaryKey(ShopCarousel record);

    /**
     * 根据shopId查找ShopCarousel
     *
     * @param shopId
     * @return
     */
    @Select("select * from shop_carousel where shop_id=#{shopId} and is_show=1 order by sort,create_time asc ")
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
    List<ShopCarousel> selectShopCarouselShopId(String shopId);

    @Select(" select c.*,p.name 'products_name' from shop_carousel c left join products p on c.products_id =p.id where c.shop_id=#{shopId} order by sort,create_time asc")
    List<Map<String,String>> selectShopCarouselShopIdBS(String shopId);

    /**
     * 查找所有ShopCarousel
     *
     * @return
     */
    @Select("select * from shop_carousel ")
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
    List<ShopCarousel> selectShopCarouselAll();

    /**
     * 根据店铺id与名称模糊查询ShopCarousel
     *
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from shop_carousel where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')")
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
    List<ShopCarousel> selectShopCarouselShopIdAndName(String shopId, String name);
}