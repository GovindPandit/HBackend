package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Pizza 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pizzaid;
	
	@Column
	private String pizzaName;
	private float price;
	private int quantity;
	
	
	public Pizza() {
		super();
	}
	
	public Pizza(int pizzaid, String pizzaName, float price, int quantity) {
		super();
		this.pizzaid = pizzaid;
		this.pizzaName = pizzaName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getPizzaid() {
		return pizzaid;
	}
	public void setPizzaid(int pizzaid) {
		this.pizzaid = pizzaid;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
