package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
        //第一步：获得sqlsession对象。
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //第二步：使用sqlSession执行sql语句
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//通过接口的class对象来获得UserDao
        List<User> userList = mapper.getUserList();//返回userlist对象

        for (User user : userList) {
            System.out.println(user);

        }
        sqlSession.close();
    }

    @Test
    public void getuserid(){
        SqlSession sqlsession  = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlsession.getMapper(UserMapper.class);//getmapper就是来获得mapper类中的信息的。

        User user = mapper.getuserid(1);
        System.out.println(user);

        sqlsession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int fax = mapper.addUser(new User(5, "fax1", "123456"));
        if(fax>0){
            System.out.println("数据插入成功！");
        }
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int aaa = mapper.updateUser(new User(4, "aaa", "654321"));
        if(aaa>0){
            System.out.println("数据更新成功");
        }
        sqlsession.commit();
        sqlsession.close();

    }
    @Test
    public void deleteUser(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(9);
        if(i>0){
            System.out.println("数据删除成功！");
        }
        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userid",5);
        map.put("password","小脑斧");
        int i = mapper.addUser2(map);

        if(i>0){
            System.out.println("数据插入成功！");
        }
        sqlsession.commit();
        sqlsession.close();

    }

    @Test
    public void getUserid2(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid",2);

        System.out.println(mapper.getUserid2(map));
        sqlsession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> fax = mapper.getUserLike("%丰%");
        for (User user : fax) {
            System.out.println(user);
        }


        session.close();
    }
}
