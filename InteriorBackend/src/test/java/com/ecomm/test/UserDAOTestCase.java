package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTestCase
{
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Ignore
	@Test
	public void registerUserTestCase()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setUsername("praveena");
		userDetail.setPassword("pravee");
		userDetail.setCustomerName("ammu");
		userDetail.setEnabled(true);
		userDetail.setAddress("thanjavur");
		userDetail.setMobileno("9876543210");
		userDetail.setEmailId("praveenaeee@gmail.com");
		userDetail.setRole("ROLE_USER");
		assertTrue("Problem in Registering the user:",userDAO.registerUser(userDetail));
		
	}
	
	@Test
	public void updateUserTestCase()
	{
		UserDetail user=new UserDetail();
		user.setUsername("thamil");
		assertTrue("Problem in updating the user:",userDAO.updateUser(user));
	}
}

  