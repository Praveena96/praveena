package com.ecomm.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;


@Controller
public class UserController
{
	@Autowired
	UserDAO userDAO;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role",role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminPage";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
				
			}
			else
			{
				loggedIn=true;
				page="UserPage";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
				
			}
		}
		return page;
	}


    @RequestMapping(value="/addregister",method=RequestMethod.POST)
	public String addUserDetail(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("emailId")String emailId,@RequestParam("mobileno")String mobileno,@RequestParam("address")String address)
	{
		UserDetail userdetail=new UserDetail();
		userdetail.setUsername(username);
		userdetail.setPassword(password);
		userdetail.setAddress(address);
		userdetail.setMobileno(mobileno);
		userdetail.setEmailId(emailId);
		userdetail.setEnabled(true);
		userDAO.registerUser(userdetail);
		
		 return "Register";
	}
}



