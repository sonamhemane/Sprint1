package com.capgemini.onlinevegetablesales.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_tbl")
public class Cart implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 465083213988493559L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer crtId;
	private Integer quantity;
    private Integer userId;
    private String vegName;
    private double vegPrice;
	
	public Cart() {

	}


	public Cart(Integer crtId, Integer quantity, Integer userId, String vegName, double vegPrice) {
		super();
		this.crtId = crtId;
		this.quantity = quantity;
		this.userId = userId;
		this.vegName = vegName;
		this.vegPrice = vegPrice;
		
	}

	
	public Integer getCrtId() {
		return crtId;
	}



	public void setCrtId(Integer crtId) {
		this.crtId = crtId;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getVegName() {
		return vegName;
	}



	public void setVegName(String vegName) {
		this.vegName = vegName;
	}



	public double getVegPrice() {
		return vegPrice;
	}



	public void setVegPrice(double vegPrice) {
		this.vegPrice = vegPrice;
	}



	@Override
	public String toString() {
		return "Cart [crtId=" + crtId + ", quantity=" + quantity + ", userId=" + userId + ", vegName=" + vegName
				+ ", vegPrice=" + vegPrice + "]";
	}

	
	
}
