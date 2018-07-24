package com.zjc.springboot.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.*;
import com.zjc.springboot.entity.User;

/**
 * 目前所有方法均为单表操作
 *
 * @author zhaojinchao
 */
public interface UserService {

    /**
     * 更新用户信息
     *
     * @param user
     * @throws Exception
     */
//	@CacheUpdate(name = "userService.updateUser",key = "#user.id",value = "#user")
    void updateUserById(User user) throws Exception;

    /**
     * 根据id获取用户信息
     *
     * @param Id
     * @return
     * @throws Exception
     */
    @Cached(name = "userService")
    User getByUserId(long Id) throws Exception;

    /**
     * 获取所有的用户信息
     *
     * @return
     * @throws Exception
     */
    List<User> getUserList() throws Exception;

    /**
     * 批量获取用户信息
     *
     * @param userIds
     * @return
     * @throws Exception
     */
    List<User> selectAll(List<Integer> userIds) throws Exception;

    /**
     * 执行添加操作之后获取对象主键的值返回
     *
     * @param user
     * @return
     * @throws Exception
     */
    Long addUser(User user) throws Exception;

    /**
     * 根据用户Id删除一条记录
     *
     * @param Id
     * @throws Exception
     */
    void deleteUserById(long Id) throws Exception;

    /**
     * 批量删除用户
     *
     * @param userIds
     * @throws Exception
     */
    void deleteAll(List<Integer> userIds) throws Exception;

    /**
     * 批量添加用户信息
     *
     * @param users
     * @throws Exception
     */
    void insertDAOProvider(List<User> users) throws Exception;

    /**
     * 批量更新用户信息
     *
     * @param users
     * @throws Exception
     */
    void updateAll(List<User> users) throws Exception;

    User getUserByJetCache(long id) throws Exception;

    void getJetCacheAllKeys();
}
