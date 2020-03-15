package com.niit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private String imagelink;
	
	public String getImagelink() {
		return imagelink;
	}

	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}
	@Column(columnDefinition="TEXT")
	private String description;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "pizza")
	private List<CartItem> cartItems;
	
	
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
