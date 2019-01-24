package com.jpa.springdatajpa.config;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * @ClassName MysqlConfig
 * @Author Smith
 * @Date 2019/1/24 11:14
 * @Description TODO
 * @Version 4.1
 */
public class MysqlConfig extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
