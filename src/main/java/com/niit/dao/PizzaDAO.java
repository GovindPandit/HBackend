package com.niit.dao;

import java.util.List;

import com.niit.model.Pizza;
import com.niit.model.User;

public interface PizzaDAO 
{
	public boolean addPizza(Pizza pizza);
	public boolean deletePizza(int pizzaid);
	public boolean updatePizza(Pizza pizza);
	public List<Pizza> displayPizzaByName(String name);
	public Pizza displayPizzaById(int pizzaid);
	public List<Pizza> displayAllPizza();
}
