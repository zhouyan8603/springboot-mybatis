package com.zjc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注意：简单返回页面Demo,如果页面出现404,请先确认项目的整体路径是否正确,再检查application.properties内容
 * 最后再检查maven本地资源thymeleafjar,全部清掉thymeleaf的jar包，利用maven更新下载
 * 参考：http://blog.csdn.net/baidu_29092471/article/details/77944956
 *
 * @author zhaojinchao
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String index() {
        return "index";
    }
}
