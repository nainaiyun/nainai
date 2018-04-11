package com.nainai.mapper;

import com.nainai.domain.Products;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ProductsMapper {
    /**
     * 根据主键id删除商品信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条商品信息
     *
     * @param record
     * @return
     */
    int insert(Products record);

    /**
     * 插入一条商品信息
     *
     * @param record
     * @return
     */
    int insertSelective(Products record);

    /**
     * 根据id查询商品信息
     *
     * @param id
     * @return
     */
    Products selectByPrimaryKey(Integer id);

    /**
     * 根据商品id更新部分字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Products record);

    /**
     * 根据商品id更新所有字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Products record);

    /**
     * 根据userId查找Products
     *
     * @param userId
     * @return
     */
    @Select("select * from products where user_id=#{userId} ")
    List<Products> selectProductsUserId(Integer userId);

    /**
     * 查找所有Products
     *
     * @return
     */
    @Select("select * from products ")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "cate_id", property = "cateId"),
            @Result(column = "market_id", property = "marketId"),
            @Result(column = "produce_area", property = "produceArea"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId")
    })
    List<Products> selectProductsAll();

    /**
     * 根据userId与商品名称模糊查询
     *
     * @param userId
     * @param name
     * @return
     */
    @Select("select * from products where user_id=#{userId} and name like  CONCAT('%',#{name},'%')")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "cate_id", property = "cateId"),
            @Result(column = "market_id", property = "marketId"),
            @Result(column = "produce_area", property = "produceArea"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId")
    })
    List<Products> selectShopBrowseUserIdAndName(Integer userId, String name);


    /**
     * 根据shopId与商品名称模糊查询
     *
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from products where shop_id=#{shopId} and name like  CONCAT('%',#{name},'%')")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "cate_id", property = "cateId"),
            @Result(column = "market_id", property = "marketId"),
            @Result(column = "produce_area", property = "produceArea"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId")
    })
    List<Products> selectShopBrowseShopIdAndName(String shopId, String name);

    /**
     * 根据店铺编号查询商品信息
     * @param shopId
     * @return
     */
    @Select("select * from products a left join product_offer b on  a.id=b.product_id where a.shop_id =#{shopId}")
    List<Map<String,String>> selectProductsandOfferByShopId(String shopId);

}
