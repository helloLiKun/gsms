package com.gsms.cn.service.authorization.impl;

import com.gsms.cn.entity.authorization.Permission;
import com.gsms.cn.entity.authorization.PermissionExample;
import com.gsms.cn.mapper.authorization.PermissionMapper;
import com.gsms.cn.service.authorization.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liKun on 2018/1/12 0012.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    public List<Permission> getPermissions() {
        PermissionExample permissionExample=new PermissionExample();
        return permissionMapper.selectByExample(permissionExample);
    }

    @Autowired
    PermissionMapper permissionMapper;
}
