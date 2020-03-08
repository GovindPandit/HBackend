package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.model.User;
import com.niit.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean addUser(User user) 
	{
		user.setAuthority("user");
		user.setEnabled(true);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userDAO.addUser(user);
	}

	@Override
	public boolean deleteUser(int userid) 
	{
		return userDAO.deleteUser(userid);
	}

	@Override
	public boolean updateUser(User user) 
	{
		return userDAO.updateUser(user);
	}

	@Override
	public User displayUserByName(String username) 
	{
		return userDAO.displayUserByName(username);
	}

	@Override
	public User displayUserById(int userid)
	{
		return userDAO.displayUserById(userid);
	}

	@Override
	public List<User> displayAllUsers() 
	{
		return userDAO.displayAllUsers();
	}
	
}
