package com.czj.interview.Controller;

import com.czj.interview.Dao.user;
import com.czj.interview.Service.indexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {

    @Autowired
    private indexService indexService;


    @RequestMapping("/")
    public String index(){
        System.out.println("111");
        return  "index";
    }

    @RequestMapping(value = "/AddBaseMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map AddBaseMessage(user user, ModelMap modelMap){
        Map map=new HashMap();
        try {
            indexService.AddBaseMessage(user);
            map.put("suceess",true);
            map.put("message","添加成功");
//            刷新页面
            List<user> list = indexService.findbyUsername("陈芝江");
            map.put("user",user);


        } catch (Exception e) {
            e.printStackTrace();
            map.put("suceess",false);
            map.put("message","添加失败");

        }
        return  map;
    }


    @ResponseBody
    @RequestMapping("/user/{id}")
    public List<user> findById(@PathVariable(value = "id") Integer id){
        List<user> list = indexService.findById(id);
        return  list;
    }



}
