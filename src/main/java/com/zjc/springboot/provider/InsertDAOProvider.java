package com.zjc.springboot.provider;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.zjc.springboot.entity.User;

/**
 * 批量添加用户信息
 * MessageFormat占位符
 * @author zhaojinchao
 *
 */
public class InsertDAOProvider {
	public String saveAll(Map map) throws Exception {
		List<User> users = (List<User>) map.get("list");
		StringBuilder sb = new StringBuilder();
		sb.append("insert into tbl_user");
		sb.append("(name,sex,phone,second_phone,add_time)");
		sb.append("values ");
		MessageFormat mf = new MessageFormat("(#'{'list[{0}].name'}',#'{'list[{0}].sex'}',#'{'list[{0}].phone'}',#'{'list[{0}].secondPhone'}',#'{'list[{0}].addTime'}')");
		for(int i=0; i<users.size(); i++)
		{
			sb.append(mf.format(new Object[]{i}));
			if (i < users.size() -1) 
			{
				sb.append(",");
			}
		}
		System.out.println("sql语句为：" + sb.toString());
		return sb.toString();
	}
}
