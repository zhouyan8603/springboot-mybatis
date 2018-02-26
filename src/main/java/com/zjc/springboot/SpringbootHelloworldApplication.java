package com.zjc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan("com.zjc.springboot.mapper")
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.zjc.springboot.controller","com.zjc.springboot.mapper","com.zjc.springboot.service"})
public class SpringbootHelloworldApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloworldApplication.class, args);
	}
}
