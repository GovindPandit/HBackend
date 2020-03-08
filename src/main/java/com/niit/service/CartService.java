package com.niit.service;

import java.util.List;

import com.niit.model.CartItem;

public interface CartService 
{
	public boolean addCartItem(CartItem cartItem);
	public boolean deleteCartItem(int cartItemId);
	public boolean updateCart(CartItem cartItem);
	public CartItem displayCartById(int pizzaid);
	public List<CartItem> displayAllCartItems(int userid);
}
