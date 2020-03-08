package com.niit.service;

import java.util.List;

import com.niit.model.Pizza;

public interface PizzaService 
{
	public boolean addPizza(Pizza pizza);
	public boolean deletePizza(int pizzaid);
	public boolean updatePizza(Pizza pizza);
	public Pizza displayPizzaByName(String name);
	public Pizza displayPizzaById(int pizzaid);
	public List<Pizza> displayAllPizza();
}
