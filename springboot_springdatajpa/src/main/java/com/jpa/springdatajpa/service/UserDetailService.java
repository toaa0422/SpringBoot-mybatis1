package com.jpa.springdatajpa.service;

import com.jpa.springdatajpa.model.UserDetail;
import com.jpa.springdatajpa.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName UserDetailRepository
 * @Author Smith
 * @Date 2019/1/24 10:42
 * @Description TODO
 */
public interface UserDetailService {

    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);


}
