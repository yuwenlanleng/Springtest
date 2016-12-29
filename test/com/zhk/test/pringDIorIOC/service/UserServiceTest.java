
package com.zhk.test.pringDIorIOC.service;

import org.junit.Test;

import com.zhk.test.pringDIorIOC.model.User;
import com.zhk.test.pringDIorIOC.spring.BeanFactory;
import com.zhk.test.pringDIorIOC.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext();

		UserService service = (UserService) applicationContext.getBean("userService");

		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.add(u);
	}

}
