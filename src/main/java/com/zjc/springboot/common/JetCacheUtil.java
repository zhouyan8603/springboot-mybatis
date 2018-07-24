package com.zjc.springboot.common;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.zjc.springboot.entity.User;
import org.springframework.stereotype.Component;

/**
 * create by zhaojinchao on 2018/7/12å
 */
@Component
public class JetCacheUtil {

//    @CreateCache(cacheType = CacheType.LOCAL,localLimit = 50,name = "userService",expire = 20)
//    public Cache<Object,User> userCache;
//
//    public Cache<Object,User> getUserCache() {
//        return userCache;
//    }

}
