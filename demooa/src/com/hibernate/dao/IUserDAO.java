package com.hibernate.dao;

import java.util.List;

import com.hibernate.beans.User;

public interface IUserDAO {

	public boolean isValid(final String username, final String password);

	public boolean isExist(String username);

	public void insertUser(User user);

	public User getUser(String userid);

	public List getUsers();
	
	public User findByUsername(final String username);

	public void deleteUser(String userid);
	
	public int getCounter(final String islogging);
	
}
