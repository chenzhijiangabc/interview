package com.czj.interview.Dao.mapper;

import com.czj.interview.Dao.user;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Select("select content from user where username=#{Username}")
    public String FindAccessbyUsername(String Username);

    @Update("update user set content=#{access} where username=#{Username}")
    public  void UpdateAccess(@Param("access") String access, @Param("Username") String Username);

    @Update("update user set schoolName=#{shcoolname},teachlevel=#{teachlevel},teachstarttime=#{teachstarttime},teachendtime=#{teachendtime} where username=#{username}")
    public void Updateteach(@Param("shcoolname") String shcoolname, @Param("teachlevel") String teachlevel, @Param("teachstarttime") Date teachstarttime, @Param("teachendtime") Date teachendtime , @Param("username") String username);


    @Update("update user set item=#{item},itemstarttime=#{itemstarttime},itemendtime=#{itemendtime},itmename=#{itmename}where username=#{username}")
    public void UpdateItem(@Param("item") String item ,@Param("username") String username,@Param("itemstarttime") Date itemstarttime,
                          @Param("itemendtime") Date itemendtime,@Param("itmename") String itmename);



}
