package com.zjc.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjc.springboot.entity.User;
import com.zjc.springboot.mapper.UserMapper;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User getByUserId(long id) throws Exception {
		return userMapper.getByUserId(id);
	}

	public List<User> getUserList() throws Exception {
		return userMapper.getUserList();
	}
}
