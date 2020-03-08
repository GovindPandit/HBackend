package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
		
	}

	public boolean deleteUser(int userid) 
	{
		try
		{
			User user=new User();
			user.setUserid(userid);
			
			Session session=sessionFactory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.delete(user);
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	public boolean updateUser(User user) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.update(user);
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	public User displayUserByName(String username) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where username= :un");
			return (User)query.setParameter("un", username).getResultList().get(0);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public User displayUserById(int userid) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where userid= :uid");
			return (User)query.setParameter("uid", userid).getResultList().get(0);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List<User> displayAllUsers() 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			return session.createQuery("from User").getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}	
	}
	
}
