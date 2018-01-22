package com.gsms.cn.service.authorization;


import com.gsms.cn.entity.authorization.Permission;

import java.util.List;

/**
 * Created by liKun on 2018/1/12 0012.
 */
public interface PermissionService {
    List<Permission> getPermissions();
}
