package com.niit.HibernateBackend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.AppConfig;
import com.niit.dao.PizzaDAO;
import com.niit.model.Pizza;
import com.niit.model.User;
import com.niit.service.PizzaService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)
public class PizzaTest 
{
	@Autowired
	PizzaService pizzaService;
	
	@Test
	public void addPizza()
	{
		Pizza p=new Pizza(1,"Pizza1",400,5);
		assertEquals(true, pizzaService.addPizza(p)); 
	}
}
