package com.zjc.springboot.controller;

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
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUserById(@RequestParam(value = "id") Integer id) {
		try {
			User user = userService.getByUserId(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
