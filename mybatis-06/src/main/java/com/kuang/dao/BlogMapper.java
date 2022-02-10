package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);
    //查询博客
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogIf2(Map map);
    //choose的使用
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //使用foreach进行查询
    List<Blog> queryBlogForeach(Map map);
}

