package com.czj.interview.Service.impl;

import com.czj.interview.Dao.mapper.IndexMapper;
import com.czj.interview.Dao.user;
import com.czj.interview.Service.indexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class indexServiceImpl implements indexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public void AddBaseMessage(user user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        indexMapper.AddBaseMessage(user);

    }

    @Override
    public List<user> findById(Integer id) {


        return indexMapper.findById(id);
    }

    @Override
    public List<user> findbyUsername(String Username) {
        List<user> list = indexMapper.findbyUsername(Username);
        if (list.size()<0 || list==null){
            return  null;
        }
        return list;
    }

    @Override
    public String FindAccessbyUsername(String Username) {
        String str = indexMapper.FindAccessbyUsername(Username);
        String after = str.replaceAll("\r\n", "<br>");
        return  after;
    }

    @Override
    public void UpdateAccess(String access,String username) {
        indexMapper.UpdateAccess(access,username);
    }

    @Override
    public void Updateteach(String shcoolname, String teachlevel, String teachstarttime, String teachendtime, String username) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = simpleDateFormat.parse(teachstarttime);
            Date endDate = simpleDateFormat.parse(teachendtime);
            indexMapper.Updateteach(shcoolname,teachlevel,startDate,endDate,username);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }



    @Override
    public void UpdateItem(String item, String username, String itemstarttime, String itemendtime, String itmename) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = simpleDateFormat.parse(itemstarttime);
        Date enddate = simpleDateFormat.parse(itemendtime);
        indexMapper.UpdateItem(item,username,startdate,enddate,itmename);
    }


}
