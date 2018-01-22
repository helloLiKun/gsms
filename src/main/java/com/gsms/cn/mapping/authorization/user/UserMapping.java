package com.gsms.cn.mapping.authorization.user;


import com.gsms.cn.mapping.authorization.AuthBase;

/**
 * Created by Administrator on 2018/1/14 0014.
 */
public interface UserMapping  extends AuthBase {
    String USERBASE=AUTHBASE+"/user";
    String REGISTER=USERBASE+"/register";
    String REGISTERSUBMIT=USERBASE+"/registerSubmitUrl";
    String TOLOGIN=USERBASE+"/toLogin";
    String LOGIN=USERBASE+"/login";
    String LOGOUT=USERBASE+"/logout";
    String UNAUTHORIZED=USERBASE+"/unauthorized";
    String LOGINSUCCESS=USERBASE+"/loginSuccess";
    String TEST1=USERBASE+"/test1";
    String TEST2=USERBASE+"/test2";
    String TEST3=USERBASE+"/test3";

}
