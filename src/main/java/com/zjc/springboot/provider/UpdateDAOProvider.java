package com.zjc.springboot.provider;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.zjc.springboot.entity.User;

/**
 * 批量更新用户信息
 * MessageFormat占位符
 * 如下是批量更新数据的sql语句
 * replace into tbl_user(id,name,sex,phone,second_phone) values (1,"赵三",1,"11002311","12312"),(2,'小四',2,"1111111","2222")
 *
 * @author zhaojinchao
 */
public class UpdateDAOProvider {
    public String updateAll(Map map) throws Exception {
        List<User> users = (List<User>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("replace into tbl_user");
        ;
        sb.append("(id,name,sex,phone,second_phone)");
        sb.append(" values");
        MessageFormat mf = new MessageFormat("#'{'list[{0}].name'}',#'{'list[{0}].sex'}',#'{'list[{0}].phone'}',#'{'list[{0}].secondPhone'}'");
        for (int i = 0; i < users.size(); i++) {
            sb.append("(" + users.get(i).getId() + "," + mf.format(new Object[]{i}) + ")");
            if (i < users.size() - 1) {
                sb.append(",");
            }
        }
        System.out.println("sql语句为：" + sb.toString());
        return sb.toString();
    }
}
