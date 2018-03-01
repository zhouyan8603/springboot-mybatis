package com.zjc.springboot.provider;

import java.util.List;
import java.util.Map;

/**
 * 批量查询用户
 * MessageFormat占位符
 * 如下是批量查询数据的sql语句
 * select * from tbl_user where id in (1,2,3,4,5)
 * @author zhaojinchao
 *
 */
public class SelectDAOProvider {
	public String selectAll(Map map) throws Exception {
		List<Integer> userIds = (List<Integer>) map.get("list");
		StringBuilder sb = new StringBuilder();
		sb.append("select * from tbl_user where id in");
		sb.append(" (");
		for(int i=0; i<userIds.size(); i++) 
		{
			sb.append("" + userIds.get(i));
			if (i < userIds.size() -1) 
			{
				sb.append(",");
			}
		}
		sb.append(")");
		System.out.println("sql语句为:" + sb.toString());
		return sb.toString();
	}
}
