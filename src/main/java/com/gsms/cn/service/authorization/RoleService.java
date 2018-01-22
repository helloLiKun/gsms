package com.gsms.cn.service.authorization;

import com.gsms.cn.entity.authorization.Permission;
import com.gsms.cn.entity.authorization.Role;

import java.util.List;

/**
 * Created by liKun on 2018/1/12 0012.
 */
public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(String id);
    List<Permission> getPermissionsById(String id);
}
