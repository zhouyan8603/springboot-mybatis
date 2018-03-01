package com.zjc.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjc.springboot.entity.User;
import com.zjc.springboot.mapper.UserMapper;

/**
 * 目前所有方法均为单表操作
 * @author zhaojinchao
 *
 */
@Service("userService")
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getByUserId(long Id) throws Exception {
		return userMapper.getByUserId(Id);
	}

	/**
	 * 获取所有的用户信息
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList() throws Exception {
		return userMapper.getUserList();
	}
	
	/**
	 * 批量获取用户信息
	 * @param userIds
	 * @return
	 * @throws Exception
	 */
	public List<User> selectAll(List<Integer> userIds) throws Exception{
		return userMapper.selectAll(userIds);
	}
	
	/**
	 * 执行添加操作之后获取对象主键的值返回
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Long addUser(User user) throws Exception {
		userMapper.addUser(user);
		return user.getId();
	}
	
	/**
	 * 根据用户Id删除一条记录
	 * @param Id
	 * @throws Exception
	 */
	public void deleteUserById(long Id) throws Exception {
		userMapper.deleteUserById(Id);
	}
	
	/**
	 * 批量删除用户
	 * @param users
	 * @throws Exception
	 */
	public void deleteAll(List<Integer> userIds) throws Exception {
		userMapper.deleteAll(userIds);
	}
	
	/**
	 * 批量添加用户信息
	 * @param users
	 * @throws Exception
	 */
	public void insertDAOProvider(List<User> users) throws Exception {
		userMapper.saveAll(users);
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUserById(User user) throws Exception {
		userMapper.updateUserById(user);
	}
	
	/**
	 * 批量更新用户信息
	 * @param users
	 * @throws Exception
	 */
	public void updateAll(List<User> users) throws Exception {
		userMapper.updateAll(users);
	}
}
