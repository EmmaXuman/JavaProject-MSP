package com.rbcdemo.model;

public class UserAddReq {
    public int Id;
    public String UserName;
    public String password;
    public  String realname;
    public  String phone;
    public  int[]  roleids;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int[] getRoleids() {
        return roleids;
    }

    public void setRoleids(int[] roleids) {
        this.roleids = roleids;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
