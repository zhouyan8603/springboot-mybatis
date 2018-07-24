package com.zjc.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheLoader;
import com.alicp.jetcache.RefreshPolicy;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.zjc.springboot.entity.User;
import com.zjc.springboot.mapper.UserMapper;
import com.zjc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * create by zhaojinchao on 2018/7/11
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @CreateCache(name = "userService",cacheType = CacheType.LOCAL,localLimit = 2,expire = 30)
    public Cache<Object,User> userCache;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUserId(long Id) throws Exception {
        User user = userMapper.getByUserId(Id);
//        userCache.put(Id,user);
        return user;
    }

    @Override
    public List<User> getUserList() throws Exception {
        List<User> users = userMapper.getUserList();
        return users;
    }

    @Override
    public List<User> selectAll(List<Integer> userIds) throws Exception {
        return null;
    }

    @Override
    public Long addUser(User user) throws Exception {
        return userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(long Id) throws Exception {
        User user = userMapper.getByUserId(Id);
        if (user == null ) {
            return;
        }
        userCache.remove(user.getId());

    }

    @Override
    public void deleteAll(List<Integer> userIds) throws Exception {

    }

    @Override
    public void insertDAOProvider(List<User> users) throws Exception {

    }

    @Override
    public void updateUserById(User user) throws Exception {
         if (user == null) {
             return;
         }
         userMapper.updateUserById(user);
         userCache.put(user.getId(),user);
    }

    @Override
    public void updateAll(List<User> users) throws Exception {

    }

    @Override
    public User getUserByJetCache(long id) throws Exception {
        return userCache.get(id);
    }

    @Override
    public void getJetCacheAllKeys() {
    }

    /**
     * 1分钟刷新一次
     */
    @PostConstruct
    public void init() throws Exception{
        RefreshPolicy policy = RefreshPolicy.newPolicy(1,TimeUnit.MINUTES);
        userCache.config().setRefreshPolicy(policy);
    }
}
