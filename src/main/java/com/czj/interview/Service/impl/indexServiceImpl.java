package com.czj.interview.Service.impl;

import com.czj.interview.Dao.mapper.IndexMapper;
import com.czj.interview.Dao.user;
import com.czj.interview.Service.indexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return indexMapper.findbyUsername(Username);
    }


}
