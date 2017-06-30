package com.yaruis.ecommercebackend.dao;

import java.util.List;

import com.yaruis.ecommercebackend.model.UserCustomer;

public interface UserDAO {

	public void save(UserCustomer user);

	public void update(UserCustomer user);

	public void delete(int userid);

	public UserCustomer get(String username);

	public List<UserCustomer> list();
	
	public boolean isValidUser (int id,String name);

}
