package com.capgemini.onlinevegetablesales.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="order_tbl")
public class Order implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2468690458401131206L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ordId;
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private double totalprice;
    private boolean paymentStatus;
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="vegetables_id")
    private List<Vegetables> vegetables;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;
    
    public Order() {
    	
    }
    

	public Order(int ordId, LocalDate date, double totalprice, boolean paymentStatus, List<Vegetables> vegetables,
			User user) {
		super();
		this.ordId = ordId;
		this.date = date;
		this.totalprice = totalprice;
		this.paymentStatus = paymentStatus;
		this.vegetables = vegetables;
		this.user = user;
	}


	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<Vegetables> getVegetables() {
		return vegetables;
	}

	public void setVegetables(List<Vegetables> vegetables) {
		this.vegetables = vegetables;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", date=" + date + ", totalprice=" + totalprice + ", paymentStatus="
				+ paymentStatus + ", vegetables=" + vegetables + ", user=" + user + "]";
	}
    

	
    /*@ManyToOne(cascade=CascadeType.ALL)
    private Cart cart;
    
    @ManyToOne()
    private User user;*/
    
    
}