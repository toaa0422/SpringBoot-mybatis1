package com.mybatis.springboot_mybatis.mapper;

import com.mybatis.springboot_mybatis.model.User;
import com.mybatis.springboot_mybatis.param.UserParam;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @ClassName UserSql
 * @Author Smith
 * @Date 2019/1/23 11:53
 * @Description 动态sql的编写
 * @Version 4.1
 */
public class UserSql {

    private static final Logger log = LoggerFactory.getLogger(UserSql.class);

    public String getList(UserParam userParam) {
        StringBuffer sql = new StringBuffer("select id, userName, passWord, user_sex as userSex, nick_name as nickName");
        sql.append(" from users where 1=1 ");
        if (userParam != null) {
            if (!StringUtils.isEmpty(userParam.getUserName())) {
                sql.append(" and userName = #{userName}");
            }
            if (!StringUtils.isEmpty(userParam.getUserSex())) {
                sql.append(" and user_sex = #{userSex}");
            }
        }
        sql.append(" order by id desc");
        sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
        log.info("getList sql is :" +sql.toString());
        return sql.toString();
    }

    public String getCount(UserParam userParam) {
        String sql= new SQL(){{
            SELECT("count(1)");
            FROM("users");
            if (!StringUtils.isEmpty(userParam.getUserName())) {
                WHERE("userName = #{userName}");
            }
            if (!StringUtils.isEmpty(userParam.getUserSex())) {
                WHERE("user_sex = #{userSex}");
            }
            //从这个toString可以看出，其内部使用高效的StringBuilder实现SQL拼接
        }}.toString();

        log.info("getCount sql is :" +sql);
        return sql;
    }

    public String update(User user) {
        String sql = new SQL() {{
            UPDATE("users");
            if(!StringUtils.isEmpty(user.getNickName())){
                SET("nick_name=#{nickName}");
            }
            if(!StringUtils.isEmpty(user.getUserName())) {
                SET("userName=#{userName}");
            }
            if(!StringUtils.isEmpty(user.getPassWord())) {
                SET("passWord=#{passWord}");
            }
            if(!StringUtils.isEmpty(user.getUserSex())) {
                SET("user_sex=#{userSex}");
            }
            WHERE("id=#{id}");
        }}.toString();
        return sql;
    }
}
