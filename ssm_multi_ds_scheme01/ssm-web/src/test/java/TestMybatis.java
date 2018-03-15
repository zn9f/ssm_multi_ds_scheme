import com.jetora.pojo.User;
import com.jetora.service.user.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.Reader;



public class TestMybatis {

    private ApplicationContext ac = null;
    private UserService userServices = null;
    @Before
    public void Before(){
        ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
        userServices = (UserService) ac.getBean("userService");
    }
    @Test
    public void testMybatis(){
        User user = userServices.getUserById(1);
        Assert.assertNotNull(user);
        System.out.println(user.getuName() + "------>" + user.getuPassword());
    }

}

