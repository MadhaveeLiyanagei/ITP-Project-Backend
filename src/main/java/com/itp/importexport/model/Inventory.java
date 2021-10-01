package com.itp.importexport.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")

public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryID;
	
	@Column(name="productID")
	private int productID;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="reOrder")
	private int reOrder;
	
	@Column(name="costPrice")
	private float costPrice;
	
	
	public Inventory() {
		
	}
	
	public Inventory(int productID, String productName, int quantity, int reOrder, float costPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.reOrder = reOrder;
		this.costPrice = costPrice;
	}
	
	public int getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReOrder() {
		return reOrder;
	}
	public void setReOrder(int reOrder) {
		this.reOrder = reOrder;
	}
	public float getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}
}


