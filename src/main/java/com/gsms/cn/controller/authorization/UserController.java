package com.gsms.cn.controller.authorization;

import com.gsms.cn.entity.authorization.User;
import com.gsms.cn.mapping.authorization.user.UserMapping;
import com.gsms.cn.service.authorization.UserService;
import com.gsms.cn.util.Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liKun on 2018/1/12 0012.
 */
@Controller
public class UserController implements UserMapping {
    @RequestMapping(REGISTER)
    public String register(ModelMap map){
        map.put("registerSubmitUrl",REGISTERSUBMIT);
        return "register";
    }

    @RequestMapping(REGISTERSUBMIT)
    @ResponseBody
    public String registerSubmit(@RequestParam("username")String username,@RequestParam("password")String password){
        User u=new User();
        u.setName(username);
        u.setPwd(Encrypt.toEncrypt(username,password));
        userService.AddUser(u);
        return "regist success";
    }

    @RequestMapping(TOLOGIN)
    public String toLogin(ModelMap map){
        map.put("loginUrl",LOGIN);
        return "toLogin";
    }
    @RequestMapping(LOGIN)
    public String login(HttpServletRequest request){
        //当前Subject
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username,Encrypt.toEncrypt(username,password));

        try {
            currentUser.login(token);
            User user=new User();
            user.setName(username);
            request.setAttribute("user",user);
            return "welcome";
        }catch (AuthenticationException e) {//登录失败
            request.setAttribute("msg", "用户名和密码错误");
            return "toLogin";
        }
    }

    @RequestMapping(LOGOUT)
    @ResponseBody
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "logout success";
    }

    @RequestMapping(UNAUTHORIZED)
    public String unauthorized(){
        return "unauthorized";
    }

    @RequestMapping(LOGINSUCCESS)
    public String loginSuccess(){
        return "welcome";
    }

    @RequestMapping(TEST1)
    public String test1(){
        return "test1";
    }
    @RequestMapping(TEST2)
    public String test2(){
        return "test2";
    }
    @RequestMapping(TEST3)
    public String test3(){
        return "test3";
    }


    @Autowired
    UserService userService;
}
