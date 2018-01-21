package com.gsms.cn.controller;

import com.gsms.cn.entity.User;
import com.gsms.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21 0021.
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        List<User> list=userService.findAll();
        return "hello";
    }

    @Autowired
    UserService userService;
}
