package com.capgemini.onlinevegetablesales.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="veg_tbl")
public class Vegetables implements Serializable{
	    /**
	     * 
	     */
	    private static final long serialVersionUID = -2992281745101123839L;
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer vegId;
	    private String vegName;
	    private double price;
	   
	  
	   
	    
	    public Vegetables() {
	    	
	    }

    public Vegetables(Integer vegId, String vegname, double price ) {
	        super();
	        this.vegId = vegId;
	        this.vegName = vegname;
	        this.price = price;
	        
	    }

	    public Integer getvegId() {
	        return vegId;
	    }

	    public void setId(Integer vegId) {
	        this.vegId = vegId;
	    }

	    public String getVegName() {
	        return vegName;
	    }

	    public void setVegName(String vegName) {
	        this.vegName = vegName;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	   
	    
	    @Override
	    public String toString() {
	        return "Vegetables [id=" + vegId + ", vegname=" + vegName + ", price=" + price +  "]";
	    }

		
	}
	


