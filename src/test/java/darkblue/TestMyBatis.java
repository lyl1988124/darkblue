package darkblue;

import javax.annotation.Resource;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyl.local.entity.user.UserEntity;
import com.lyl.local.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"})  
public class TestMyBatis {

	  
	    private Logger logger = LoggerFactory.getLogger(TestMyBatis.class);
	    
	//  private ApplicationContext ac = null;  
	    @Resource
	    private UserService userService = null;  
	  
	//  @Before  
	//  public void before() {  
//	      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//	      userService = (IUserService) ac.getBean("userService");  
	//  }  
	  
	    @Test  
	    public void test1() { 
	        UserEntity user = userService.getUserById(1);  
	         System.out.println(user.getUserName());
	        logger.info("值："+user.getUserName()); 
	    }
}

