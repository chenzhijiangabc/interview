package com.czj.interview.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    @PostMapping("/loginUser")
    public String login(String username, String password, Model model){
        System.out.println("表单提交");
        if(null== username||null ==password){
            return "login";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
       /*获取主题*/
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            model.addAttribute("username",username);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return  "login";
        }
            return "index";
    }

    /*退出登录*/
    @RequestMapping("loginout")
    public void loginout(){
        SecurityUtils.getSubject().logout();
    }

}
