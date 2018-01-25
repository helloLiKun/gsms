package com.gsms.cn.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by likun on 2018/1/22 0022.
 */
@Configuration
public class ShiroConfig {
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
    //指定加密方式，也可以在这里加入缓存，当用户超过五次登陆错误就锁定该用户禁止不断尝试登陆
//    @Bean(name = "hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        credentialsMatcher.setHashIterations(2);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }

    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroRealm shiroRealm() {
        ShiroRealm realm = new ShiroRealm();
//        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    @Bean(name = "ehCacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
        return securityManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager  securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionManager = new LinkedHashMap<>();
        filterChainDefinitionManager.put("/base/authBase/user/register","anon");
        filterChainDefinitionManager.put("/base/authBase/user/registerSubmitUrl","anon");
        filterChainDefinitionManager.put("/base/authBase/user/toLogin", "anon");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/base/authBase/user/login", "anon");
        filterChainDefinitionManager.put("/css/**", "anon");
        filterChainDefinitionManager.put("/images/**", "anon");
        filterChainDefinitionManager.put("/js/**", "anon");
        filterChainDefinitionManager.put("/css/**", "anon");
        filterChainDefinitionManager.put("/upload/**", "anon");
        filterChainDefinitionManager.put("/base/authBase/user/test1", "authc,roles[normal]");//anon 可以理解为不拦截
        filterChainDefinitionManager.put("/base/authBase/user/test2",  "authc,perms[test2]");//静态资源不拦截
        filterChainDefinitionManager.put("/base/authBase/user/test3","authc,roles[admin]");//其他资源全部拦截
        filterChainDefinitionManager.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//        登录路径
        shiroFilterFactoryBean.setLoginUrl("/base/authBase/user/toLogin");
        shiroFilterFactoryBean.setSuccessUrl("/base/authBase/user/loginSuccess");
//        用户访问无权限的链接时跳转此页面
        shiroFilterFactoryBean.setUnauthorizedUrl("unauthorized");
        return shiroFilterFactoryBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }
    //thymeleaf模板引擎和shiro整合时使用
//    @Bean(name = "shiroDialect")
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }
}
