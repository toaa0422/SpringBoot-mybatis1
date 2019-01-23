package com.mybatis.springboot_mybatis.mapper;

import com.mybatis.springboot_mybatis.model.User;
import com.mybatis.springboot_mybatis.param.UserParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

	List<User> getAll();

	List<User> getList(UserParam userParam);

	int getCount(UserParam userParam);

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int delete(Long id);

}