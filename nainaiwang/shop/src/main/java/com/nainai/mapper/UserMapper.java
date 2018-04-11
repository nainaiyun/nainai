package com.nainai.mapper;

import com.nainai.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加一条用户信息
     * @param record
     * @return
     */
    int insert(User record);


    /**
     * 添加一条用户信息
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据id修改用户信息部分字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据id修改用户信息全部字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据shopId查找User
     * @param shopId
     * @return
     */
    @Select("select * from user where shop_id=#{shopId} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "true_name", property = "trueName"),
            @Result(column = "head_photo", property = "headPhoto"),
            @Result(column = "agent_pass", property = "agentPass"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "login_time", property = "loginTime"),
            @Result(column = "session_id", property = "sessionId"),
            @Result(column = "cert_status", property = "certStatus"),
            @Result(column = "pay_secret", property = "paySecret"),
            @Result(column = "login_ip", property = "loginIp"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "is_false", property = "isFalse")
    })
    User selectUserShopId(String shopId);

    /**
     * 查找所有User
     * @return
     */
    @Select("select * from user ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "true_name", property = "trueName"),
            @Result(column = "head_photo", property = "headPhoto"),
            @Result(column = "agent_pass", property = "agentPass"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "login_time", property = "loginTime"),
            @Result(column = "session_id", property = "sessionId"),
            @Result(column = "cert_status", property = "certStatus"),
            @Result(column = "pay_secret", property = "paySecret"),
            @Result(column = "login_ip", property = "loginIp"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "is_false", property = "isFalse")
    })
    List<User> selectUserAll();

    /**
     * 根据店铺id与username模糊查询User
     * @param shopId
     * @param name
     * @return
     */
    @Select("select * from user where shop_id=#{shopId} and username like  CONCAT('%',#{name},'%') ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "true_name", property = "trueName"),
            @Result(column = "head_photo", property = "headPhoto"),
            @Result(column = "agent_pass", property = "agentPass"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "login_time", property = "loginTime"),
            @Result(column = "session_id", property = "sessionId"),
            @Result(column = "cert_status", property = "certStatus"),
            @Result(column = "pay_secret", property = "paySecret"),
            @Result(column = "login_ip", property = "loginIp"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "is_false", property = "isFalse")
    })
    List<User> selectUserShopIdAndName(String shopId, String name);

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username} ")
    @Results({
            @Result(column = "shop_id", property = "shopId"),
            @Result(column = "true_name", property = "trueName"),
            @Result(column = "head_photo", property = "headPhoto"),
            @Result(column = "agent_pass", property = "agentPass"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "login_time", property = "loginTime"),
            @Result(column = "session_id", property = "sessionId"),
            @Result(column = "cert_status", property = "certStatus"),
            @Result(column = "pay_secret", property = "paySecret"),
            @Result(column = "login_ip", property = "loginIp"),
            @Result(column = "user_no", property = "userNo"),
            @Result(column = "is_false", property = "isFalse")
    })
    User selectUserByUsername(String username);
    /**
     * 根据username查询店铺id
     * @param username
     * @return
     */
    @Select("select shop_id from user where username = #{username} ")
    Map<String ,String> selectShopIdByUsername(String username);

    /**
     * 根据username查询店铺id
     * @param username
     * @return
     */
    @Select("select type from user where username = #{username} ")
    Map<String ,String> selectUserTypeByUsername(String username);

    /**
     * 根据username获取session信息
     * @param username
     * @return
     */
    @Select(" select  u.id,u.username,u.session_id,s.session_expire,s.session_data from user u " +
            " left join user_session s on u.session_id=s.session_id where u.username=#{username} ")
    Map<String ,String> selectSession(String username);

    /**
     * 根据username获取user_account信息
     * @param id
     * @return
     */
    @Select("select u.id,u.username,a.fund,a.freeze from user u left join " +
            "user_account a on a.user_id = u.id where u.id=#{id};")
    Map<String ,String> selectAccount(Integer id);
    /**
     * 根据username获取user_account信息
     * @param username
     * @return
     */
    @Select("select u.id,u.login_time,u.session_id ,s.session_expire from" +
            " user u left join user_session s on u.session_id=s.session_id " +
            " where username=#{username}")
    Map<String ,Object> isLogin(String username);

    /**
     * session_id获取username
     * @param sd
     * @return
     */
    @Select("select u.username,s.session_expire from user u left join " +
            "user_session s on u.session_id=s.session_id where u.session_id = #{sd}")
    List<Map<String ,Object>> selectUsernameBySessionId(String sd);
}