package com.nainai.mapper;

import com.nainai.domain.Bid;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BidMapper {
    /**
     * 根据id删除一条招标信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加一条招标信息
     *
     * @param record
     * @return
     */
    int insert(Bid record);

    /**
     * 添加一条招标信息
     *
     * @param record
     * @return
     */
    int insertSelective(Bid record);

    /**
     * 根据id查询招标信息
     *
     * @param id
     * @return
     */
    Bid selectByPrimaryKey(Integer id);

    /**
     * 根据id更新招标信息表的部分字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Bid record);

    /**
     * 根据id更新招标信息表的全部字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Bid record);

    /**
     * 根据用户编号查询该用户下所有的招标信息
     *
     * @param userId
     * @return
     */
    @Select("select * from bid where user_id=#{userId} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "yq_user", property = "yqUser"),
            @Result(column = "top_cate", property = "topCate"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "pro_address", property = "proAddress"),
            @Result(column = "begin_time", property = "beginTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "bid_require", property = "bidRequire"),
            @Result(column = "pro_brief", property = "proBrief"),
            @Result(column = "bid_content", property = "bidContent"),
            @Result(column = "pack_type", property = "packType"),
            @Result(column = "doc_begin", property = "docBegin"),
            @Result(column = "doc_price", property = "docPrice"),
            @Result(column = "supply_bail", property = "supplyBail"),
            @Result(column = "open_way", property = "openWay"),
            @Result(column = "pay_way", property = "payWay"),
            @Result(column = "bid_person", property = "bidPerson"),
            @Result(column = "cont_person", property = "contPerson"),
            @Result(column = "cont_address", property = "contAddress"),
            @Result(column = "cont_email", property = "contEmail"),
            @Result(column = "cont_phone", property = "contPhone"),
            @Result(column = "cont_tax", property = "contTax"),
            @Result(column = "agent_person", property = "agentPerson"),
            @Result(column = "agent_address", property = "agentAddress"),
            @Result(column = "agent_email", property = "agentEmail"),
            @Result(column = "agent_phone", property = "agentPhone"),
            @Result(column = "agent_tax", property = "agentTax"),
            @Result(column = "bail_pay_way", property = "bailPayWay"),
            @Result(column = "bail_is_refund", property = "bailIsRefund"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "admin_message", property = "adminMessage")
    })
    List<Bid> selectBidUserId(Integer userId);

    /**
     * 查询所有的招标信息
     *
     * @return
     */
    @Select("select * from bid ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "yq_user", property = "yqUser"),
            @Result(column = "top_cate", property = "topCate"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "pro_address", property = "proAddress"),
            @Result(column = "begin_time", property = "beginTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "bid_require", property = "bidRequire"),
            @Result(column = "pro_brief", property = "proBrief"),
            @Result(column = "bid_content", property = "bidContent"),
            @Result(column = "pack_type", property = "packType"),
            @Result(column = "doc_begin", property = "docBegin"),
            @Result(column = "doc_price", property = "docPrice"),
            @Result(column = "supply_bail", property = "supplyBail"),
            @Result(column = "open_way", property = "openWay"),
            @Result(column = "pay_way", property = "payWay"),
            @Result(column = "bid_person", property = "bidPerson"),
            @Result(column = "cont_person", property = "contPerson"),
            @Result(column = "cont_address", property = "contAddress"),
            @Result(column = "cont_email", property = "contEmail"),
            @Result(column = "cont_phone", property = "contPhone"),
            @Result(column = "cont_tax", property = "contTax"),
            @Result(column = "agent_person", property = "agentPerson"),
            @Result(column = "agent_address", property = "agentAddress"),
            @Result(column = "agent_email", property = "agentEmail"),
            @Result(column = "agent_phone", property = "agentPhone"),
            @Result(column = "agent_tax", property = "agentTax"),
            @Result(column = "bail_pay_way", property = "bailPayWay"),
            @Result(column = "bail_is_refund", property = "bailIsRefund"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "admin_message", property = "adminMessage")
    })
    List<Bid> selectBidAll();

    /**
     * 根据userId与项目名称模糊查询
     *
     * @param userId
     * @param proName
     * @return
     */
    @Select("select * from bid where user_id=#{userId} and pro_name like  CONCAT('%',#{proName},'%')")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "yq_user", property = "yqUser"),
            @Result(column = "top_cate", property = "topCate"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "pro_address", property = "proAddress"),
            @Result(column = "begin_time", property = "beginTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "bid_require", property = "bidRequire"),
            @Result(column = "pro_brief", property = "proBrief"),
            @Result(column = "bid_content", property = "bidContent"),
            @Result(column = "pack_type", property = "packType"),
            @Result(column = "doc_begin", property = "docBegin"),
            @Result(column = "doc_price", property = "docPrice"),
            @Result(column = "supply_bail", property = "supplyBail"),
            @Result(column = "open_way", property = "openWay"),
            @Result(column = "pay_way", property = "payWay"),
            @Result(column = "bid_person", property = "bidPerson"),
            @Result(column = "cont_person", property = "contPerson"),
            @Result(column = "cont_address", property = "contAddress"),
            @Result(column = "cont_email", property = "contEmail"),
            @Result(column = "cont_phone", property = "contPhone"),
            @Result(column = "cont_tax", property = "contTax"),
            @Result(column = "agent_person", property = "agentPerson"),
            @Result(column = "agent_address", property = "agentAddress"),
            @Result(column = "agent_email", property = "agentEmail"),
            @Result(column = "agent_phone", property = "agentPhone"),
            @Result(column = "agent_tax", property = "agentTax"),
            @Result(column = "bail_pay_way", property = "bailPayWay"),
            @Result(column = "bail_is_refund", property = "bailIsRefund"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "admin_message", property = "adminMessage")
    })
    List<Bid> selectShopBrowseUserIdAndProName(Integer userId, String proName);

    /**
     * 根据shopId与项目名称模糊查询
     *
     * @param shopId
     * @param proName
     * @return
     */
    @Select("select * from bid where shop_id=#{shopId} and pro_name like  CONCAT('%',#{proName},'%')")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "yq_user", property = "yqUser"),
            @Result(column = "top_cate", property = "topCate"),
            @Result(column = "pro_name", property = "proName"),
            @Result(column = "pro_address", property = "proAddress"),
            @Result(column = "begin_time", property = "beginTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "bid_require", property = "bidRequire"),
            @Result(column = "pro_brief", property = "proBrief"),
            @Result(column = "bid_content", property = "bidContent"),
            @Result(column = "pack_type", property = "packType"),
            @Result(column = "doc_begin", property = "docBegin"),
            @Result(column = "doc_price", property = "docPrice"),
            @Result(column = "supply_bail", property = "supplyBail"),
            @Result(column = "open_way", property = "openWay"),
            @Result(column = "pay_way", property = "payWay"),
            @Result(column = "bid_person", property = "bidPerson"),
            @Result(column = "cont_person", property = "contPerson"),
            @Result(column = "cont_address", property = "contAddress"),
            @Result(column = "cont_email", property = "contEmail"),
            @Result(column = "cont_phone", property = "contPhone"),
            @Result(column = "cont_tax", property = "contTax"),
            @Result(column = "agent_person", property = "agentPerson"),
            @Result(column = "agent_address", property = "agentAddress"),
            @Result(column = "agent_email", property = "agentEmail"),
            @Result(column = "agent_phone", property = "agentPhone"),
            @Result(column = "agent_tax", property = "agentTax"),
            @Result(column = "bail_pay_way", property = "bailPayWay"),
            @Result(column = "bail_is_refund", property = "bailIsRefund"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "admin_message", property = "adminMessage")
    })
    List<Bid> selectShopBrowseShopIdAndProName(String shopId, String proName);

}