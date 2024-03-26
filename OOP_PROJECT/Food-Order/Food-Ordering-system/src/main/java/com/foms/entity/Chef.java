package com.foms.entity;

public class Chef {
	
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String phone;
	private String category;
	
	
	public Chef() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Chef(String fullName, String email, String password,
			String phone, String category) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.category = category;
	}
	
	
	


	public Chef(int id, String fullName, String email,String password,
			String phone, String category) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.category = category;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}



	
	
	
	
	
}
