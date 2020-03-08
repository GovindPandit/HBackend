package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.PizzaDAO;
import com.niit.model.Pizza;
import com.niit.model.User;

@Repository("pizzaDAO")
@Transactional
public class PizzaDAOImpl implements PizzaDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addPizza(Pizza pizza) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(pizza);
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deletePizza(int pizzaid) 
	{
		try
		{
			Pizza pizza=new Pizza();
			pizza.setPizzaid(pizzaid);
			
			Session session=sessionFactory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.delete(pizza);
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updatePizza(Pizza pizza) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.update(pizza);
			tx.commit();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Pizza displayPizzaByName(String name) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Pizza where pizzaName= :pn");
			return (Pizza)query.setParameter("pn", name).getResultList().get(0);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Pizza displayPizzaById(int pizzaid) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Pizza where pizzaid= :pid");
			return (Pizza)query.setParameter("pid", pizzaid).getResultList().get(0);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Pizza> displayAllPizza() 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			return session.createQuery("from Pizza").getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}	
	}
}
