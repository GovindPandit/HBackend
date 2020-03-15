package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;
import com.niit.model.Pizza;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCartItem(CartItem cartItem) 
	{
		sessionFactory.getCurrentSession().save(cartItem);
		return true;
	}

	@Override
	public boolean deleteCartItem(int cartItemId) 
	{
		CartItem cartItem=new CartItem();
		cartItem.setCartItemId(cartItemId);
		
		sessionFactory.getCurrentSession().delete(cartItem);
		return true;
	}

	@Override
	public boolean updateCart(CartItem cartItem) 
	{
		sessionFactory.getCurrentSession().update(cartItem);
		return true;
	}

	@Override
	public CartItem displayCartById(int cartItemId) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from CartItem where cartItemId= :cartItemId");
			return (CartItem)query.setParameter("cartItemId", cartItemId).getResultList().get(0);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	

	@Override
	public List<CartItem> displayAllCartItems(int userid) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from CartItem where user.userid= :userid");
			return query.setParameter("userid", userid).getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}	
	}

}
