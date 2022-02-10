package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserList();

    User getuserid(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);


}
