package com.zjc.springboot.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zjc.springboot.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from tbl_user as tb where tb.id=#{Id}")
	User getByUserId(long Id) throws Exception;
	
	@Select("select * from tbl_user")
	List<User> getUserList() throws Exception;

}
