package com.example.demo.model;

public class Shipment {

	private String name;
	private int quantity;
	private int discount;
	
	
	
	public Shipment() {
		super();
	}
	public Shipment(String name, int quantity, int discount) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Shipment [name=" + name + ", quantity=" + quantity + ", discount=" + discount + "]";
	}
	
	
}
