package com.zjc.springboot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "tbl_user")
public class User {
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "sex")
	private int sex;
	@Column(name = "phone")
	private String phone;
	@Column(name = "second_phone")
	private String secondPhone;
	@Column(name = "add_time")
	private Date addTime;
	
	public User() {
		
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
