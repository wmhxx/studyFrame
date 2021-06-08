package com.wmhxx.cloud.dao;

import com.wmhxx.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :wangmh
 * @date :2021年06月06日  20:11
 **/
@Mapper
public interface UserDao {

    boolean insertUser(User user);

}
