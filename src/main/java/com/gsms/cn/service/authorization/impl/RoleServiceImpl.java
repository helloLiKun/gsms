package com.gsms.cn.service.authorization.impl;

import com.gsms.cn.entity.authorization.*;
import com.gsms.cn.mapper.authorization.PermissionMapper;
import com.gsms.cn.mapper.authorization.RoleMapper;
import com.gsms.cn.mapper.authorization.RolePermissionMapper;
import com.gsms.cn.service.authorization.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liKun on 2018/1/12 0012.
 */
@Service
public class RoleServiceImpl implements RoleService {
    public List<Role> getAllRoles() {
        RoleExample roleExample=new RoleExample();
        return roleMapper.selectByExample(roleExample);
    }

    public Role getRoleById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public List<Permission> getPermissionsById(String id) {
        List<Permission> permissions=new ArrayList<Permission>();
        RolePermissionExample rolePermissionExample=new RolePermissionExample();
        RolePermissionExample.Criteria c=rolePermissionExample.createCriteria();
        c.andRIdEqualTo(id);
        List<RolePermission> list=rolePermissionMapper.selectByExample(rolePermissionExample);
        if(list!=null && list.size()>0){
            for(RolePermission rp:list){
                Permission p=permissionMapper.selectByPrimaryKey(rp.getpId());
                if(p!=null){
                    permissions.add(p);
                }
            }
        }
        return permissions;
    }

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    PermissionMapper permissionMapper;
}
