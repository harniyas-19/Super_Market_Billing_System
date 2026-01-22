package com.wipro.sbs.entity;
import java.util.ArrayList;

public class Bill {
	private String billId;
	private ArrayList<BillItem> items;
	private double totalAmount;
	
	public Bill(String billId,ArrayList<BillItem> items,double totalAmount) {
		this.billId=billId;
		this.items=items;
		this.totalAmount=totalAmount;
	}
	public String getBillId() {
		return billId;
	}
	public ArrayList<BillItem> getItems() {
		return items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public void setItems(ArrayList<BillItem> items) {
		this.items = items;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
