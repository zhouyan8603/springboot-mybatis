package com.zjc.springboot.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zjc.springboot.entity.User;
import com.zjc.springboot.provider.InsertDAOProvider;

@Mapper
public interface UserMapper {
	
	@Select("select * from tbl_user as tb where tb.id=#{Id}")
	User getByUserId(long Id) throws Exception;
	
	@Select("select * from tbl_user")
	List<User> getUserList() throws Exception;
	
	@Insert("insert into tbl_user(name,sex,phone,second_phone,add_time) values (#{name},#{sex},#{phone},#{secondPhone},#{addTime})")
	@Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")//添加记录返回主键id
	Long addUser(User user) throws Exception;
	
	
	@Delete("delete from tbl_user where id=#{Id}")
	void deleteUserById(long Id) throws Exception;
	
	@InsertProvider(type = InsertDAOProvider.class ,method = "saveAll")
	void saveAll(@Param("list") List<User> users) throws Exception;
}
