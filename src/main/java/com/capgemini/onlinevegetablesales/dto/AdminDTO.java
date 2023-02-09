package com.capgemini.onlinevegetablesales.dto;

public class AdminDTO {
	
	private int admId;
	private String admName;
	private Long phone;
	private String email;
	private String password;
	
	
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDTO(String admName, Long phone, String email, String password) {
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
	
	
}
