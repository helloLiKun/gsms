package com.gsms.cn.config;

import com.alibaba.druid.util.StringUtils;
import com.gsms.cn.entity.authorization.Permission;
import com.gsms.cn.entity.authorization.Role;
import com.gsms.cn.entity.authorization.User;
import com.gsms.cn.service.authorization.PermissionService;
import com.gsms.cn.service.authorization.RoleService;
import com.gsms.cn.service.authorization.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by likun on 2018/1/22 0022.
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 添加角色
     * @param username
     * @param info
     */
    private void addRole(String username, SimpleAuthorizationInfo info) {
        User user=userService.getUserByName(username);
        if(user!=null){
            List<Role> roles = userService.getRolesById(user.getId());
            if(roles!=null&&roles.size()>0){
                for (Role role : roles) {
                    info.addRole(role.getName());
                }
            }
        }

    }

    /**
     * 添加权限
     * @param username
     * @param info
     * @return
     */
    private SimpleAuthorizationInfo addPermission(String username,SimpleAuthorizationInfo info) {
        List<Permission> permissions = new ArrayList<Permission>();
        User user=userService.getUserByName(username);
        if(user!=null){
            List<Role> roles = userService.getRolesById(user.getId());
            if(roles!=null&&roles.size()>0){
                for (Role role : roles) {
                    List<Permission> list=roleService.getPermissionsById(role.getId());
                    permissions.addAll(list);
                }
            }
        }

        for (Permission permission : permissions) {
            info.addStringPermission(permission.getValue());//添加权限
        }
        return info;
    }


    /**
     * 获取授权信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //用户名
        String username = (String) principals.getPrimaryPrincipal();
        //根据用户名来添加相应的权限和角色
        if(!StringUtils.isEmpty(username)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            addPermission(username,info);
            addRole(username, info);
            return info;
        }
        return null;
    }


    /**
     * 登录验证
     */
    protected org.apache.shiro.authc.AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken ) throws AuthenticationException {
        //令牌——基于用户名和密码的令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        //令牌中可以取出用户名
        String accountName = token.getUsername();
        //让shiro框架去验证账号密码
        if(!StringUtils.isEmpty(accountName)){
            User user = userService.getUserByName(accountName);
            if(user != null){
                return new SimpleAuthenticationInfo(user.getName(), user.getPwd(), token.getUsername());
            }
        }

        return null;
    }
}