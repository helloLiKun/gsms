package com.gsms.cn.mapper.authorization;

import com.gsms.cn.entity.authorization.User;
import com.gsms.cn.entity.authorization.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER
     *
     * @mbggenerated Mon Jan 22 10:54:32 CST 2018
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}