package com.gsms.cn.entity.authorization;

public class RolePermission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_PERMISSION.ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_PERMISSION.R_ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    private String rId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_PERMISSION.P_ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    private String pId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_PERMISSION.ID
     *
     * @return the value of T_ROLE_PERMISSION.ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_PERMISSION.ID
     *
     * @param id the value for T_ROLE_PERMISSION.ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_PERMISSION.R_ID
     *
     * @return the value of T_ROLE_PERMISSION.R_ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    public String getrId() {
        return rId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_PERMISSION.R_ID
     *
     * @param rId the value for T_ROLE_PERMISSION.R_ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    public void setrId(String rId) {
        this.rId = rId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_PERMISSION.P_ID
     *
     * @return the value of T_ROLE_PERMISSION.P_ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    public String getpId() {
        return pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_PERMISSION.P_ID
     *
     * @param pId the value for T_ROLE_PERMISSION.P_ID
     *
     * @mbggenerated Mon Jan 22 10:20:04 CST 2018
     */
    public void setpId(String pId) {
        this.pId = pId;
    }
}