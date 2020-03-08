package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;
import com.niit.service.CartService;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	CartDAO cartDAO;
	
	@Override
	public boolean addCartItem(CartItem cartItem) 
	{
		cartDAO.addCartItem(cartItem);
		return true;
	}

	@Override
	public boolean deleteCartItem(int cartItemId) 
	{
		cartDAO.deleteCartItem(cartItemId);
		return true;
	}

	@Override
	public boolean updateCart(CartItem cartItem) 
	{
		cartDAO.updateCart(cartItem);
		return true;
	}

	@Override
	public CartItem displayCartById(int pizzaid) 
	{
		return cartDAO.displayCartById(pizzaid);
	}

	@Override
	public List<CartItem> displayAllCartItems(int userid) 
	{
		return cartDAO.displayAllCartItems(userid);
	}

}
