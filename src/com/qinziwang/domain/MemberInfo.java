package com.qinziwang.domain;

import java.sql.Timestamp;
public class MemberInfo {
    /*��Ա���*/
    private String userNo;
    public String getUserNo() {
        return userNo;
    }
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /*��Ա����*/
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /*�����ƺ�*/
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*��Ա����*/
    private Timestamp birthday;
    public Timestamp getBirthday() {
        return birthday;
    }
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    /*��ϵqq*/
    private String qq;
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }

    /*�����ַ*/
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    /*��ϵ�绰*/
    private String telphone;
    public String getTelphone() {
        return telphone;
    }
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /*��ϵ��ַ*/
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    /*��Ա��Ƭ*/
    private String photo;
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}