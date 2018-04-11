package com.nainai.mapper;

import com.nainai.domain.ProductOffer;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ProductOfferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductOffer record);

    int insertSelective(ProductOffer record);

    ProductOffer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductOffer record);

    int updateByPrimaryKey(ProductOffer record);

    @Select("select * from product_offer ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "sub_mode", property = "subMode"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "old_offer", property = "oldOffer"),
            @Result(column = "price_l", property = "priceL"),
            @Result(column = "price_r", property = "priceR"),
            @Result(column = "accept_area", property = "acceptArea"),
            @Result(column = "accept_day", property = "acceptDay"),
            @Result(column = "acc_type", property = "accType"),
            @Result(column = "offer_fee", property = "offerFee"),
            @Result(column = "is_del", property = "isDel"),
            @Result(column = "apply_time", property = "applyTime"),
            @Result(column = "finish_time", property = "finishTime"),
            @Result(column = "expire_time", property = "expireTime"),
            @Result(column = "admin_msg", property = "adminMsg"),
            @Result(column = "weight_type", property = "weightType"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "max_num", property = "maxNum"),
            @Result(column = "sell_num", property = "sellNum"),
            @Result(column = "jing_stepprice", property = "jingStepprice"),
            @Result(column = "offer_sort", property = "offerSort")
    })
    List<ProductOffer> selectProductOfferAll();

    @Select("select * from product_offer where shop_id= #{shopId}")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "classify_id", property = "classifyId"),
            @Result(column = "module_id", property = "moduleId"),
            @Result(column = "navigation_id", property = "navigationId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "sub_mode", property = "subMode"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "old_offer", property = "oldOffer"),
            @Result(column = "price_l", property = "priceL"),
            @Result(column = "price_r", property = "priceR"),
            @Result(column = "accept_area", property = "acceptArea"),
            @Result(column = "accept_day", property = "acceptDay"),
            @Result(column = "acc_type", property = "accType"),
            @Result(column = "offer_fee", property = "offerFee"),
            @Result(column = "is_del", property = "isDel"),
            @Result(column = "apply_time", property = "applyTime"),
            @Result(column = "finish_time", property = "finishTime"),
            @Result(column = "expire_time", property = "expireTime"),
            @Result(column = "admin_msg", property = "adminMsg"),
            @Result(column = "weight_type", property = "weightType"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "max_num", property = "maxNum"),
            @Result(column = "sell_num", property = "sellNum"),
            @Result(column = "jing_stepprice", property = "jingStepprice"),
            @Result(column = "offer_sort", property = "offerSort")
    })
    List<ProductOffer> selectProductOfferByShopId(String shopId);


    /**
     * 查询商品的报盘id及商品名称
     * @param shopId
     * @return
     */
    @Select("select o.id,p.name from product_offer o left join products p " +
            " on o.product_id = p.id where o.shop_id= #{shopId} and status=1 order by apply_time asc ")
    List<Map<String,String>> selectProductOfferProNameByShopId(String shopId);

    /**
     * 查询商品的报盘及商品信息
     * @param shopId
     * @return
     */
    @Select("select id,pro_name from product_offer where shop_id= #{shopId}")
    List<Map<String,String>> selectProductAndOffer(String shopId);


    /**
     * 查询商品的报盘信息以及报盘所属信息
     * @param shopId
     * @return
     */
    @Select("select o.id,p.name,o.price,o.type,o.mode,c.id 'classify_id',c.name 'classify_name'," +
            " n.id 'navigation_id',n.name 'navigation_name',m.id 'module_id',m.name 'module_name'" +
            " from  product_offer o " +
            " left join products p on o.product_id = p.id " +
            " left join shop_classify c on o.classify_id=c.id " +
            " left join shop_navigation n on o.navigation_id =n.id " +
            "    left join shop_module m on o.module_id = m.id " +
            "    where o.shop_id =#{shopId} and status=1 ")
    List<Map<String,String>> selectProductOfferAndSubordinateByShopId(String shopId);

    /**
     * 根据条件查询商品列表
     * @param shopId
     * @param proName
     * @param classifyId
     * @return
     */
    @Select("select o.shop_id,p.id'product_id',o.id'offer_id',p.name'product_name'," +
            "p.note'product_note' ,p.img,p.unit ,p.currency,o.price from product_offer o" +
            " left join products p on o.product_id = p.id where" +
            " o.shop_id=#{0} " +
            "and p.name like  CONCAT('%',#{1},'%') " +
            "and o.classify_id like CONCAT('%',#{2},'%') and status=1 order by create_time asc")
    List<Map<String,String>> selectProductOfferListingByClassifyId(String shopId, String proName, String classifyId);


    /**
     * 根据条件查询商品列表
     * @param shopId
     * @param proName
     * @param moduleId
     * @return
     */
    @Select("select o.shop_id,p.id'product_id',o.id'offer_id',p.name'product_name'," +
            "p.note'product_note' ,p.img,p.unit ,p.currency,o.price from product_offer o" +
            " left join products p on o.product_id = p.id where" +
            " o.shop_id=#{0} " +
            "and p.name like  CONCAT('%',#{1},'%') " +
            "and o.module_id like CONCAT('%',#{2},'%') and status=1  order by create_time asc")
    List<Map<String,String>> selectProductOfferListingByModuleId(String shopId, String proName, String moduleId);

    /**
     * 根据条件查询商品列表
     * @param shopId
     * @param proName
     * @param navigationId
     * @return
     */
    @Select("select o.shop_id,p.id'product_id',o.id'offer_id',p.name'product_name'," +
            "p.note'product_note' ,p.img,p.unit ,p.currency,o.price from product_offer o" +
            " left join products p on o.product_id = p.id where" +
            " o.shop_id=#{0} " +
            "and p.name like  CONCAT('%',#{1},'%') " +
            "and o.navigation_id like CONCAT('%',#{2},'%') and status=1 order by create_time asc")
    List<Map<String,String>> selectProductOfferListingByNavigationId(String shopId, String proName, String navigationId);

    @Select("select o.shop_id,p.id'product_id',o.id'offer_id',p.name'product_name'," +
            "p.note'product_note' ,p.img,p.unit ,p.currency,o.price from product_offer o" +
            " left join products p on o.product_id = p.id where" +
            " o.shop_id=#{0} " +
            "and p.name like  CONCAT('%',#{1},'%') and status=1 order by create_time asc")
    List<Map<String,String>> selectProductOfferListingByShopId(String shopId, String proName);


    @Select("select product_id from product_offer where id=#{offerId}")
    Map<String,Integer> selectProductIdByOfferId(Integer offerId);

}