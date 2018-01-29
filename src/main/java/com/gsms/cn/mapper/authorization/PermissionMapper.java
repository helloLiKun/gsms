package com.gsms.cn.mapper.authorization;

import com.gsms.cn.entity.authorization.Permission;
import com.gsms.cn.entity.authorization.PermissionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int countByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int deleteByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    Permission selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PERMISSION_TAB
     *
     * @mbggenerated Mon Jan 22 10:19:27 CST 2018
     */
    int updateByPrimaryKey(Permission record);
}