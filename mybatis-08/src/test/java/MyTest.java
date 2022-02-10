import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        mapper.updateUser(new User(2,"aaaa","bbbb"));
        System.out.println("=======================");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);
        sqlSession.close();
    }
}
