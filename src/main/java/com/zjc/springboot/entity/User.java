package com.zjc.springboot.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Setter
    @Getter
    private long id;
    @Column(name = "name")
    @Setter
    @Getter
    private String name;
    @Column(name = "sex")
    @Setter
    @Getter
    private int sex;
    @Column(name = "phone")
    @Setter
    @Getter
    private String phone;
    @Column(name = "second_phone")
    @Setter
    @Getter
    private String secondPhone;
    @Column(name = "add_time")
    @Setter
    @Getter
    private Date addTime;

    private static User user = new User();

    public User() {
    }

    public static User getInstance() {
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
