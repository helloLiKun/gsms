package com.gsms.cn.service.impl;

import com.gsms.cn.entity.User;
import com.gsms.cn.entity.UserExample;
import com.gsms.cn.mapper.UserMapper;
import com.gsms.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/21 0021.
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<User> findAll() {
        UserExample userExample=new UserExample();
        return userMapper.selectByExample(userExample);
    }

    @Autowired
    UserMapper userMapper;
}
