package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.PizzaDAO;
import com.niit.model.Pizza;
import com.niit.service.PizzaService;

@Service
public class PizzaServiceImpl implements PizzaService
{

	@Autowired
	PizzaDAO pizzaDAO;
	
	@Override
	public boolean addPizza(Pizza pizza)
	{
		return pizzaDAO.addPizza(pizza);
	}

	@Override
	public boolean deletePizza(int pizzaid) 
	{
		return pizzaDAO.deletePizza(pizzaid);
	}

	@Override
	public boolean updatePizza(Pizza pizza) 
	{
		return pizzaDAO.updatePizza(pizza);
	}

	@Override
	public Pizza displayPizzaByName(String name) 
	{
		return pizzaDAO.displayPizzaByName(name);
	}

	@Override
	public Pizza displayPizzaById(int pizzaid)
	{
		return pizzaDAO.displayPizzaById(pizzaid);
	}

	@Override
	public List<Pizza> displayAllPizza() 
	{
		return pizzaDAO.displayAllPizza();
	}

}
