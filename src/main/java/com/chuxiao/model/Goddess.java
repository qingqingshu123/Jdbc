package com.chuxiao.model;


import java.sql.Date;
import java.sql.Timestamp;

/**
 * 数据库对应的实体类
 */
public class Goddess {
    private int id;
    private String userName;
    private int sex;
    private  int age;
    private Date birthday;
    //    java.util.Date日期格式为：年月日时分秒
    //    以下分别对应 数据库中的date time timestamp
    //    java.sql.Date日期格式为：年月日
    //    java.sql.Time日期格式为：时分秒
    //    java.sql.Timestamp日期格式为：年月日时分秒纳秒（毫微秒）
    private String email;
    private String mobile;
    private String createUser;
    private String updateUser;
    private Timestamp createDate;
    private Timestamp updateDate;
    private int isdel;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goddess{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", isdel=" + isdel +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public java.sql.Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.sql.Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }
}
