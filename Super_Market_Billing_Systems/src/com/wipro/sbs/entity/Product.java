package com.wipro.sbs.entity;

public class Product {
	private String productId;
	private String productName;
	private double price;
	private int stock;
	
	public Product(String productId,String productName,double price,int stock) {
		this.productId=productId;
		this.productName=productName;
		this.price=price;
		this.stock=stock;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
