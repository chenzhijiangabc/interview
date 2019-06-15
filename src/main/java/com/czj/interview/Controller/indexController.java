package com.czj.interview.Controller;

import com.czj.interview.Dao.user;
import com.czj.interview.Service.indexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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

  @RequestMapping("/login")
    public String login(){
        return  "login";
    }

    @RequestMapping(value = "/AddBaseMessage",method = RequestMethod.POST)
    @ResponseBody
    public Map AddBaseMessage(user user, ModelMap modelMap){
        Map map=new HashMap();
        try {
//            再添加的时候需要获取当前登录用户的登录名username  再完成登录功能  user.setusername=*****
            indexService.AddBaseMessage(user);
            map.put("suceess",true);
            map.put("message","添加成功");
//            刷新页面
            List<user> list = indexService.findbyUsername("陈芝江");
//            格式化时间
            user myuser=list.get(0);
            Date updated = user.getUpdated();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
            String updatetime = simpleDateFormat.format(updated);
            map.put("updatetime",updatetime);
            map.put("user",list);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("suceess",false);
            map.put("message","添加失败");

        }
        return  map;
    }

//    接收自我评价
    @PostMapping("/UpdateAccess")
    @ResponseBody
    public Map UpdateAccess(String access){
        Map map =new HashMap();
        try {
            indexService.UpdateAccess(access, "陈芝江");
            String str = indexService.FindAccessbyUsername("陈芝江");
            map.put("message","更新成功");
            map.put("suceess",true);
            map.put("content",str);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message",false);
            map.put("message","添加失败");
        }
        return map;
    }


//    更新教育背景
        @PostMapping("/UpdateTeach")
        @ResponseBody
        public Map Updateteach(String shcoolname,String teachlevel,String teachstarttime,String teachendtime ){
        Map map=new HashMap();
            try {
                indexService.Updateteach(shcoolname,teachlevel,teachstarttime,teachendtime,"陈芝江");
                map.put("message","更新成功");
                map.put("suceess",true);

                List<user> list = indexService.findbyUsername("陈芝江");
                user user=list.get(0);
                Date teachstarttime1 = user.getTeachstarttime();
                Date teachendtime1 = user.getTeachendtime();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.MM");
                teachstarttime = simpleDateFormat.format(teachstarttime1);
                teachendtime = simpleDateFormat.format(teachendtime1);
                map.put("teachstarttime",teachstarttime);
                map.put("teachendtime",teachendtime);
                map.put("user",user);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("message",false);
                map.put("message","添加失败");
            }
            return  map;

        }


//        更新项目经验
        @ResponseBody
        @RequestMapping("/UpdateItem")
        public Map UpdateItem(String item,String itemstarttime,String itemendtime,String itmename) {
            Map map = new HashMap();
            try {
              indexService.UpdateItem(item,"陈芝江",itemstarttime,itemendtime,itmename);
                map.put("message","更新成功");
                map.put("suceess",true);
                List<user> list = indexService.findbyUsername("陈芝江");
                user user=list.get(0);
                item = user.getItem();
                item = item.replaceAll("\r\n", "<br>");
                map.put("item",item);

                Date itemstarttime1 = user.getItemstarttime();
                Date itemendtime1 = user.getItemendtime();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.MM");
                map.put("TextItemName",user.getItmename());
                map.put("TextItemstarttime",simpleDateFormat.format(itemstarttime1));
                map.put("TextItemendtime",  simpleDateFormat.format(itemendtime1));
            } catch (Exception e) {
                e.printStackTrace();
                map.put("message",false);
                map.put("message","添加失败");
            }
            return map;
        }




    @ResponseBody
    @RequestMapping("/user/{id}")
    public List<user> findById(@PathVariable(value = "id") Integer id){
        List<user> list = indexService.findById(id);
        return  list;
    }





}
