package com.ecomm.dao;

import com.ecomm.model.UserDetail;

public interface UserDAO 
{
	public boolean registerUser(UserDetail userDetail);
	public boolean  updateUser(UserDetail userDetail);
    public UserDetail getUser(String username);
 
}
