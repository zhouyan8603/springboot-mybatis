package com.zjc.springboot.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.alicp.jetcache.Cache;
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

    /**
     * 根据ID查询User
     **/
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

    /**
     * 从缓存中查找User
     **/
    @RequestMapping(value = "/getUserByCache", method = RequestMethod.GET)
    public User getUserByJetCache(@RequestParam(value = "id") Long id) {
        try {
            User user = userService.getUserByJetCache(id);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有的User
     **/
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUser() {
        try {
            List<User> users = userService.getUserList();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加User,返回主键Id
     **/
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user) {
        try {
            long userId = userService.addUser(user);
            System.out.println("userId is" + userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 批量添加User
     **/
    @RequestMapping(value = "/saveAll", method = RequestMethod.POST)
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

    /**
     * 根据Id更新User
     **/
    @RequestMapping(value = "/updateUserById", method = RequestMethod.GET)
    public void updateUserById(User user) {
        try {
            userService.updateUserById(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/updateAll", method = RequestMethod.POST)
    public void updateAll() {
        try {
            List<User> users = new ArrayList<User>();
            User user = new User();
            user.setId(15);
            user.setName("赵四");
            user.setSex(2);
            user.setPhone("0000000000");
            user.setSecondPhone("007");
            users.add(user);
            User user1 = new User();
            user1.setId(16);
            user1.setName("王五");
            user1.setSex(1);
            user1.setPhone("1111111111");
            user1.setSecondPhone("008");
            users.add(user1);
            userService.updateAll(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据Id删除User
     **/
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
    public void deleteUserById(long Id) {
        try {
            userService.deleteUserById(Id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除User
     **/
    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        try {
            userService.deleteAll(Arrays.asList(16, 17));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量获取用户信息
     **/
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<User> selectAll() {
        try {
            List<User> users = userService.selectAll(Arrays.asList(14, 15));
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
