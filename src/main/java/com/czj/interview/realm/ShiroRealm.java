package com.czj.interview.realm;

import com.czj.interview.Dao.user;
import com.czj.interview.Service.indexService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private indexService indexService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    /*用户认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("用户认证");
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken)token;
            //获取用户名
        String username = usernamePasswordToken.getUsername();
            //获取密码
        String password = new String(usernamePasswordToken.getPassword());

        List<user> list = indexService.findbyUsername(username);

        user user = list.get(0);

        if (null!=user){
          return  new   SimpleAuthenticationInfo(user,password,getName());
        }
        return null;
    }
}
