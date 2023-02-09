package com.capgemini.onlinevegetablesales.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "admin_tbl") 
public class Admin implements Serializable{
	
	private static final long serialVersionUID = -834540450852695913L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int admId;
	private String admName;
	private Long phone;
	private String email;
	private String password;
	
	
	public Admin() {
		
	}
	
	public Admin(String admName, Long phone, String email, String password) {
		super();
		this.admName = admName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		
	}
	public int getAdmId() {
		return admId;
	}
	public void setAdmId(int admId) {
		this.admId = admId;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin [admId=" + admId + ", admName=" + admName + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

	
   
}

 