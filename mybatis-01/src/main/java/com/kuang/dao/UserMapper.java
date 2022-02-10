package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //模糊查询
    List<User>  getUserLike(String value);

    List<User> getUserList();

    User getuserid(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    //map的使用__增
    int addUser2(Map<String,Object> map);
    //map的使用__查
    User getUserid2(Map<String,Object> map);
}
