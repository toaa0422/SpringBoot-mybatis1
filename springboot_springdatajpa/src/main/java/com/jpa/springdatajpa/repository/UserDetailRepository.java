package com.jpa.springdatajpa.repository;

import com.jpa.springdatajpa.model.UserDetail;
import com.jpa.springdatajpa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName UserDetailRepository
 * @Author Smith
 * @Date 2019/1/24 10:46
 * @Description TODO
 * @Version 4.1
 */
public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>,
        JpaRepository<UserDetail, Long> {

    @Query("select u.userName as userName, u.email as email, d.introduction as introduction , d.hobby as hobby from User u , UserDetail d " +
            "where u.id=d.userId  and  d.hobby = ?1 ")
    List<UserInfo> findUserInfo(String hobby);
}
