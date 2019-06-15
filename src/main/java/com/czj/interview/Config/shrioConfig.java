package com.czj.interview.Config;

import com.czj.interview.realm.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class shrioConfig {

    /*将自定义的ShiroRealm加到容器中*/
    @Bean
    public ShiroRealm myshiroRealm(){
        ShiroRealm   shiroRealm=new ShiroRealm();
        return  shiroRealm;
    }
    //权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myshiroRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        //登出
        map.put("/logout","logout");
        //对所有用户认证
        map.put("/**","authc");
        map.put("/login","anon");
        map.put("/css/**","anon");
        map.put("/img/**","anon");
        map.put("/loginUser","anon");

        //登录
        shiroFilterFactoryBean.setLoginUrl("login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }




}
