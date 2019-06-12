package com.czj.interview.Dao.mapper;

import com.czj.interview.Dao.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IndexMapper {
    @Insert("insert into user(name,phone,email,created,updated,source_type,nick_name,qq) values(#{name},#{phone},#{email},#{created},#{updated},#{sourceType},#{nickName},#{qq})")
    public void AddBaseMessage(user user);

    @Select("select * from user where id=#{id}")
    public List<user> findById(Integer id);

    @Select("select * from user where username=#{Username}")
    public List<user> findbyUsername(String Username);
}
