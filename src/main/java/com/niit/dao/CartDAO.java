package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.Pizza;

public interface CartDAO 
{
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(int cartItemId);
	public boolean updateCart(CartItem cartItem);
	public CartItem displayCartById(int pizzaid);
	public List<CartItem> displayAllCartItems(int userid);
}
