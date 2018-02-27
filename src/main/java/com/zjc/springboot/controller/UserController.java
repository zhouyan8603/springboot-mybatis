package com.zjc.springboot.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zjc.springboot.entity.User;
import com.zjc.springboot.service.UserService;

@EnableAutoConfiguration
@RestController
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public User getUserById(@RequestParam(value = "id") Integer id) {
		try {
			User user = userService.getByUserId(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getUserList",method = RequestMethod.GET)
	public List<User> getUser() {
		try {
			List<User> users = userService.getUserList();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	public String addUser(User user) {
		try {
			long userId = userService.addUser(user);
			System.out.println("userId is" + userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteUserById" ,method = RequestMethod.GET)
	public void deleteUserById(long Id) {
		try {
			userService.deleteUserById(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "saveAll" ,method = RequestMethod.POST)
	public void saveAll() {
		try {
			List<User> users = new ArrayList<User>();
			User user = new User();
			user.setName("将进酒");
			user.setSex(1);
			user.setPhone("110");
			user.setSecondPhone("011");
			user.setAddTime(new Date());
			users.add(user);
			User user1 = new User();
			user1.setName("水调歌头");
			user1.setSex(2);
			user1.setPhone("120");
			user1.setSecondPhone("021");
			user1.setAddTime(new Date());
			users.add(user1);
			userService.insertDAOProvider(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
