package com.gsms.cn.service.authorization;

import com.gsms.cn.entity.authorization.Role;
import com.gsms.cn.entity.authorization.User;

import java.util.List;

/**
 * Created by liKun on 2018/1/12 0012.
 */
public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    User getUserByName(String name);
    List<Role> getRolesById(String id);
    void AddUser(User user);

}
