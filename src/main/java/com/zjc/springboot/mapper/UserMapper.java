package com.zjc.springboot.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.zjc.springboot.entity.User;
import com.zjc.springboot.provider.DeleteDAOProvider;
import com.zjc.springboot.provider.InsertDAOProvider;
import com.zjc.springboot.provider.SelectDAOProvider;
import com.zjc.springboot.provider.UpdateDAOProvider;

@Mapper
public interface UserMapper {
	
	/**
	 * 根据id查询User
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tbl_user as tb where tb.id=#{Id}")
	User getByUserId(long Id) throws Exception;
	
	/**
	 * 查询所有User
	 * @return
	 * @throws Exception
	 */
	@Select("select * from tbl_user")
	List<User> getUserList() throws Exception;
	
	/**
	 * 批量查询用户
	 * @param userIds
	 * @return
	 * @throws Exception
	 */
	@SelectProvider(type = SelectDAOProvider.class ,method = "selectAll")
	List<User> selectAll(@Param("list") List<Integer> userIds) throws Exception; 
	
	/**
	 * 添加用户,返回主键ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into tbl_user(name,sex,phone,second_phone,add_time) values (#{name},#{sex},#{phone},#{secondPhone},#{addTime})")
	@Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")
	Long addUser(User user) throws Exception;
	
	/**
	 * 批量添加用户
	 * @param users
	 * @throws Exception
	 */
	@InsertProvider(type = InsertDAOProvider.class ,method = "saveAll")
	void saveAll(@Param("list") List<User> users) throws Exception;
	
	/**
	 * 更新用户信息
	 * @param user
	 * @throws Exception
	 */
	@Update("update tbl_user set name=#{name},sex=#{sex},phone=#{phone},second_phone=#{secondPhone} where id=#{id}")
	void updateUserById(User user) throws Exception;
	
	/**
	 * 批量更新用户信息
	 * @param users
	 * @throws Exception
	 */
	@UpdateProvider(type = UpdateDAOProvider.class ,method = "updateAll")
	void updateAll(@Param("list") List<User> users) throws Exception; 
	
	/**
	 * 删除用户信息
	 * @param Id
	 * @throws Exception
	 */
	@Delete("delete from tbl_user where id=#{Id}")
	void deleteUserById(long Id) throws Exception;
	
	/**
	 * 批量删除用户信息
	 * @param users
	 * @throws Exception
	 */
	@DeleteProvider(type = DeleteDAOProvider.class ,method = "deleteAll")
	void deleteAll(@Param("list") List<Integer> userIds) throws Exception;
}
