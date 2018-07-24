package com.zjc.springboot;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.zjc.springboot.common.SofaTracerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = {"com.zjc.springboot.service", "com.zjc.springboot.common"})
public class SpringbootHelloworldApplication extends WebMvcConfigurerAdapter {

    //extends WebMvcConfigurerAdapter

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloworldApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSofaTracer());
        super.addInterceptors(registry);
    }

    @Bean
    HandlerInterceptor getSofaTracer() {
        return new SofaTracerUtil();
    }
}
