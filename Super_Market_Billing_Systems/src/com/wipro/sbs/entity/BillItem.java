package com.wipro.sbs.entity;

public class BillItem {
	private String productId;
	private int quantity;
	
	public BillItem(String productId,int quantity) {
		this.productId=productId;
		this.quantity=quantity;
	}

	public String getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
