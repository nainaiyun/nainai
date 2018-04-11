package com.nainai.mapper;

import com.nainai.domain.OrderSell;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderSellMapper {
    /**
     * 根据id删除一条订单信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条订单信息
     *
     * @param record
     * @return
     */
    int insert(OrderSell record);

    /**
     * 插入一条订单信息
     *
     * @param record
     * @return
     */
    int insertSelective(OrderSell record);

    /**
     * 根据id查询订单信息
     *
     * @param id
     * @return
     */
    OrderSell selectByPrimaryKey(Integer id);

    /**
     * 根据id修改订单信息部分字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderSell record);

    /**
     * 根据id修改订单信息全部字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrderSell record);

    /**
     * 根据用户编号查询该用户的所有订单信息
     *
     * @param userId
     * @return
     */
    @Select("select * from order_sell where user_id=#{userId} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "pay_deposit", property = "payDeposit"),
            @Result(column = "buyer_deposit_payment", property = "buyerDepositPayment"),
            @Result(column = "pay_deposit_time", property = "payDepositTime"),
            @Result(column = "buyer_deposit_clientid", property = "buyerDepositClientid"),
            @Result(column = "pay_retainage", property = "payRetainage"),
            @Result(column = "retainage_payment", property = "retainagePayment"),
            @Result(column = "retainage_clientid", property = "retainageClientid"),
            @Result(column = "contract_status", property = "contractStatus"),
            @Result(column = "seller_deposit", property = "sellerDeposit"),
            @Result(column = "seller_deposit_payment", property = "sellerDepositPayment"),
            @Result(column = "seller_deposit_clientid", property = "sellerDepositClientid"),
            @Result(column = "jiesuan_prove", property = "jiesuanProve"),
            @Result(column = "reduce_amount", property = "reduceAmount"),
            @Result(column = "reduce_remark", property = "reduceRemark"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "is_lock", property = "isLock"),
            @Result(column = "complate_prove", property = "complateProve")
    })
    List<OrderSell> selectOrderSellUserId(Integer userId);


    /**
     * 查询所有的订单信息
     *
     * @return
     */
    @Select("select * from order_sell ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "pay_deposit", property = "payDeposit"),
            @Result(column = "buyer_deposit_payment", property = "buyerDepositPayment"),
            @Result(column = "pay_deposit_time", property = "payDepositTime"),
            @Result(column = "buyer_deposit_clientid", property = "buyerDepositClientid"),
            @Result(column = "pay_retainage", property = "payRetainage"),
            @Result(column = "retainage_payment", property = "retainagePayment"),
            @Result(column = "retainage_clientid", property = "retainageClientid"),
            @Result(column = "contract_status", property = "contractStatus"),
            @Result(column = "seller_deposit", property = "sellerDeposit"),
            @Result(column = "seller_deposit_payment", property = "sellerDepositPayment"),
            @Result(column = "seller_deposit_clientid", property = "sellerDepositClientid"),
            @Result(column = "jiesuan_prove", property = "jiesuanProve"),
            @Result(column = "reduce_amount", property = "reduceAmount"),
            @Result(column = "reduce_remark", property = "reduceRemark"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "is_lock", property = "isLock"),
            @Result(column = "complate_prove", property = "complateProve")
    })
    List<OrderSell> selectOrderSellAll();

    @Select("select * from order_sell where shop_id=#{shopId} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "pay_deposit", property = "payDeposit"),
            @Result(column = "buyer_deposit_payment", property = "buyerDepositPayment"),
            @Result(column = "pay_deposit_time", property = "payDepositTime"),
            @Result(column = "buyer_deposit_clientid", property = "buyerDepositClientid"),
            @Result(column = "pay_retainage", property = "payRetainage"),
            @Result(column = "retainage_payment", property = "retainagePayment"),
            @Result(column = "retainage_clientid", property = "retainageClientid"),
            @Result(column = "contract_status", property = "contractStatus"),
            @Result(column = "seller_deposit", property = "sellerDeposit"),
            @Result(column = "seller_deposit_payment", property = "sellerDepositPayment"),
            @Result(column = "seller_deposit_clientid", property = "sellerDepositClientid"),
            @Result(column = "jiesuan_prove", property = "jiesuanProve"),
            @Result(column = "reduce_amount", property = "reduceAmount"),
            @Result(column = "reduce_remark", property = "reduceRemark"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "is_lock", property = "isLock"),
            @Result(column = "complate_prove", property = "complateProve")
    })
    List<OrderSell> selectOrderSellByShopIdPage(String shopId);


    @Select("select * from order_sell where shop_id=#{0} and contract_status=#{1}")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "offer_no", property = "offerNo"),
            @Result(column = "offer_id", property = "offerId"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "pay_deposit", property = "payDeposit"),
            @Result(column = "buyer_deposit_payment", property = "buyerDepositPayment"),
            @Result(column = "pay_deposit_time", property = "payDepositTime"),
            @Result(column = "buyer_deposit_clientid", property = "buyerDepositClientid"),
            @Result(column = "pay_retainage", property = "payRetainage"),
            @Result(column = "retainage_payment", property = "retainagePayment"),
            @Result(column = "retainage_clientid", property = "retainageClientid"),
            @Result(column = "contract_status", property = "contractStatus"),
            @Result(column = "seller_deposit", property = "sellerDeposit"),
            @Result(column = "seller_deposit_payment", property = "sellerDepositPayment"),
            @Result(column = "seller_deposit_clientid", property = "sellerDepositClientid"),
            @Result(column = "jiesuan_prove", property = "jiesuanProve"),
            @Result(column = "reduce_amount", property = "reduceAmount"),
            @Result(column = "reduce_remark", property = "reduceRemark"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "is_lock", property = "isLock"),
            @Result(column = "complate_prove", property = "complateProve")
    })
    List<OrderSell> selectOrderSellByShopIdAndStatusPage(String shopId, int contractStatus);

    /**
     * 本月销售总额
     * @param shopId
     * @return
     */
    @Select("select sum(amount)'sumAmount' from order_sell where date_format(create_time,'%Y-%m')=" +
            " date_format(now(),'%Y-%m')  and shop_id=#{shopId} ")
    Map<String ,String > selectAmount(String shopId);

    /**
     * 本月支付金额
     * @param shopId
     * @return
     */
    @Select("select sum(amount) monthAmount from order_sell where date_format(create_time,'%Y-%m')=" +
            " date_format(now(),'%Y-%m')  and shop_id=#{0} and contract_status=#{1}")
    Map<String ,String > selectPayAmount(String shopId, int contractStatus);


    /**
     * 本月支付买家数
     * @param shopId
     * @return
     */
    @Select("select count(id) countId from order_sell where date_format(create_time,'%Y-%m')=" +
            " date_format(now(),'%Y-%m')  and shop_id=#{0} and contract_status=#{1}")
    Map<String ,String > selectPayCount(String shopId, int contractStatus);
}