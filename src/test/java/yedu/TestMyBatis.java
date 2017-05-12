package yedu;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.yedu.pojo.User;
import cn.com.yedu.service.IUserService;
import cn.com.yedu.util.PropertiesUtils;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})

public class TestMyBatis {

	 private static Logger logger = Logger.getLogger(TestMyBatis.class);
//		private ApplicationContext ac = null;
	  @Resource
	  private IUserService userService ;

//		@Before
//		public void before() {
//			ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//			userService = (IUserService) ac.getBean("userService");
//		}

	  @Test
	  public void test1() {
	    User user = userService.getUserById(1);
	    System.err.println(user.getUserName());
	    // System.out.println(user.getUserName());
	    // logger.info("值："+user.getUserName());
	    logger.info(JSON.toJSONString(user));
	  }
	  
	  @Test
	  public void TestPropertiesUtils(){
		  System.out.println(PropertiesUtils.getContextProperty("appid"));
		  System.out.println(PropertiesUtils.getContextProperty("APPID"));
//		  System.out.println(PropertiesUtils.getContextProperty("log4j.appender.Console"));
	  }

}
