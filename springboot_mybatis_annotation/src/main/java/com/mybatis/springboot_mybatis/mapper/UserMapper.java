package com.mybatis.springboot_mybatis.mapper;

import com.mybatis.springboot_mybatis.enums.UserSexEnum;
import com.mybatis.springboot_mybatis.model.User;
import com.mybatis.springboot_mybatis.param.UserParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM users")
	@Results({
			@Result(property = "userSex", column="user_sex",javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name",javaType = String.class)
	})
	List<User> getAll();

	@SelectProvider(type = UserSql.class,method = "getList")
	List<User> getList(UserParam userParam);

	@SelectProvider(type = UserSql.class,method = "getCount")
	int getCount(UserParam userParam);

	/*注意$与#的区别*/

	@Select("SELECT * FROM users WHERE user_sex = #{user_sex}")
	List<User> getListByUserSex(@Param("user_sex") String userSex);

	@Select("SELECT * FROM users WHERE username=#{username} AND user_sex = #{user_sex}")
	List<User> getListByNameAndSex(Map<String, Object> map);

	@Select("SELECT * FROM users WHERE ID = #{id}")
	@Results({
			@Result(property = "userSex", column="user_sex",javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name",javaType = String.class)
	})
	User getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName},#{passWord},#{userSex})")
	void insert(User user);

	@UpdateProvider(type = UserSql.class,method = "update")
	int update(User user);

	@Update({"<script> ",
			"UPDATE users ",
			"<set>" ,
			" <if test='userName != null'>userName=#{userName},</if>" ,
			" <if test='nickName != null'>nick_name=#{nickName},</if>" ,
			" </set> ",
			"where id=#{id} " ,
			"</script>"})
	int updateUser(User user);

	@Delete("DELETE FROM users WHERE id = #{id}")
	int delete(Long id);

}