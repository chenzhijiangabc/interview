package com.czj.interview.Service;

import com.czj.interview.Dao.user;

import java.util.List;

public interface indexService {
    public void AddBaseMessage(user user);

    public List<user> findById(Integer id);

    public List<user> findbyUsername(String Username);
}
