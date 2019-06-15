package com.czj.interview.Dao;

import java.io.Serializable;
import java.util.Date;

public class user implements Serializable{
    private Long id;
    /*登录账号*/
    private String username;

    private String password;

    private String phone;

    private String email;

    private Date created;

    private Date updated;

    private String sourceType;
        /*民族*/
    private String nickName;
        /*名称*/
    private String name;

    private String status;

    private String headPic;

    private String qq;

    private String sex;

    private  String content;

    private String schoolName;

    private  String teachlevel;

    private  Date teachstarttime;

    private  Date teachendtime;

    private  String  item;

    private Date itemstarttime;

    private  Date itemendtime;

    private  String itmename;

    public Date getItemstarttime() {
        return itemstarttime;
    }

    public void setItemstarttime(Date itemstarttime) {
        this.itemstarttime = itemstarttime;
    }

    public Date getItemendtime() {
        return itemendtime;
    }

    public void setItemendtime(Date itemendtime) {
        this.itemendtime = itemendtime;
    }

    public String getItmename() {
        return itmename;
    }

    public void setItmename(String itmename) {
        this.itmename = itmename;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTeachlevel() {
        return teachlevel;
    }

    public void setTeachlevel(String teachlevel) {
        this.teachlevel = teachlevel;
    }

    public Date getTeachstarttime() {
        return teachstarttime;
    }

    public void setTeachstarttime(Date teachstarttime) {
        this.teachstarttime = teachstarttime;
    }

    public Date getTeachendtime() {
        return teachendtime;
    }

    public void setTeachendtime(Date teachendtime) {
        this.teachendtime = teachendtime;
    }

    user(){
        super();
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", sourceType='" + sourceType + '\'' +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", headPic='" + headPic + '\'' +
                ", qq='" + qq + '\'' +
                ", sex='" + sex + '\'' +
                ", content='" + content + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", teachlevel='" + teachlevel + '\'' +
                ", teachstarttime=" + teachstarttime +
                ", teachendtime=" + teachendtime +
                ", item='" + item + '\'' +
                ", itemstarttime=" + itemstarttime +
                ", itemendtime=" + itemendtime +
                ", itmename='" + itmename + '\'' +
                '}';
    }
}
