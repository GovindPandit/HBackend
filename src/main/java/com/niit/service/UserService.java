package com.niit.service;

import java.util.List;

import com.niit.model.User;

public interface UserService 
{
	public boolean addUser(User user);
	public boolean deleteUser(int userid);
	public boolean updateUser(User user);
	public User displayUserByName(String username);
	public User displayUserById(int userid);
	public List<User> displayAllUsers();
}
