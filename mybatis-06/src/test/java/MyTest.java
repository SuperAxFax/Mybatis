import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getID());
        blog.setTitle("java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getID());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getID());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.commit();//不要忘记提交，否则数据库中会没有数据。
        sqlSession.close();
    }

    @Test
    public void queryBlogIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap Map = new HashMap();
        Map.put("title", "java如此简单");
        Map.put("author", "狂神说");
        Map.put("views", 9999);

        List<Blog> blogs = mapper.queryBlogIf(Map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap Map = new HashMap();
        //Map.put("title","java如此简单");
        Map.put("author", "狂神说");
        //Map.put("views",9999);

        List<Blog> blogs = mapper.queryBlogChoose(Map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap Map = new HashMap();
        Map.put("title", "java如此简单2");
        Map.put("author", "狂神说");
        Map.put("id", "e40d341068e94e3e9f9d91831e470ce9");

        mapper.updateBlog(Map);

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void queryBlogIf2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap Map = new HashMap();
        Map.put("title", "java如此简单");
        Map.put("author", "狂神说");
        Map.put("views", 9999);

        List<Blog> blogs = mapper.queryBlogIf2(Map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogForEach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}