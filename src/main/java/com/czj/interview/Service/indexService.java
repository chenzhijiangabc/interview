package com.czj.interview.Service;

import com.czj.interview.Dao.user;

import java.text.ParseException;
import java.util.List;

public interface indexService {
//    添加或更新个人信息
    public void AddBaseMessage(user user);

    public List<user> findById(Integer id);
    //  查询基本信息
    public List<user> findbyUsername(String Username);
    //查询个人评价
    public String FindAccessbyUsername(String Username);
//    添加或更新个人评价
    public  void UpdateAccess(String access,String username);
//    更新教育背景
    public void Updateteach(String shcoolname,String teachlevel,String teachstarttime,String teachendtime,String username);
//    更新项目经验
public void UpdateItem( String item ,  String username,  String itemstarttime, String itemendtime, String itmename) throws ParseException;



}
