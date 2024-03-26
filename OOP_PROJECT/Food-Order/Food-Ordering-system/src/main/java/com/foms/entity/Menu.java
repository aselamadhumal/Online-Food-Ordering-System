package com.foms.entity;

public class Menu {
	
	private int id;
	private String foodName;
	private String price;
	private String description;
//	private String image;

	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Menu(String foodName, String price, String description) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.description = description;
//		this.image = image;
	}





	public Menu(int id, String foodName, String price, String description) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.description = description;
//		this.image = image;

	}





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFoodName() {
		return foodName;
	}



	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}	
	
}
