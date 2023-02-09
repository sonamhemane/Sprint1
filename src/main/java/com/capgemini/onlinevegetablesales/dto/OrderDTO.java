package com.capgemini.onlinevegetablesales.dto;

import java.time.LocalDate;

public class OrderDTO {
	
	private int id;
    private String User_name;
    private String date;
    private double price;
    private int quantity;
    private double totalprice;
    private String vegetablename;
    private boolean payment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getVegetablename() {
		return vegetablename;
	}
	public void setVegetablename(String vegetablename) {
		this.vegetablename = vegetablename;
	}
	public boolean isPayment() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
    
	
}
