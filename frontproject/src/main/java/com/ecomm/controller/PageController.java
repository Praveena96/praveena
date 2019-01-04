package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class PageController
{
	@RequestMapping(value="/header")
	public String showHeader()
	{
		return "Header";
		
	}
@RequestMapping(value="/login")
public String showLogin()
{
	return "Login";
	
}
@RequestMapping(value="/register")
public String showRegister()
	{
		return "Register";
		

}
@RequestMapping(value="/aboutus")
public String showAboutUs()
	{
		return "AboutUs";
}
@RequestMapping(value="/contactus")
public String showContactUs()
	{
		return "ContactUs";
}
@RequestMapping(value="/updatecategory")
public String showUpdateCategory()
	{
		return "UpdateCategory";

     }
@RequestMapping(value="/updateproduct")
public String showUpdateProduct()
	{
		return "UpdateProduct";

     }

}

