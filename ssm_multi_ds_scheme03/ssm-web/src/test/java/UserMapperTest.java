import com.jetora.dao.user.UserMapper;
import com.jetora.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {
    /*
    @Test
    public void testSelectById(){
        //获取sqlSession
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectByPrimaryKey(1);
            Assert.assertNotNull(user);
            Assert.assertEquals("root",user.getuName());
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size()>0);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testInsert(){
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setuName("test11");
            user.setuPassword("testroot");
            int result = userMapper.insert(user);
            Assert.assertEquals(1,result);
            //id为null，没有给id赋值，并且没有配置回写id的值
            Assert.assertNull(user.getuId());
        }finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
    */
}
