package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreateOrder")

public class CreateOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="Order_NO")
	private String orderno;
	
	@Column(name ="Product_Name")
	private String productName;
	
	@Column(name ="Product_Price")
	private int productPrice;
	
	@Column(name ="Quantity")
	private String quantity;
	
	
	public CreateOrder() {

	}


	public CreateOrder(int id, String orderno, String productName, int productPrice, String quantity) {
		super();
		this.id = id;
		this.orderno = orderno;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public String getOrderno() {
		return orderno;
	}


	public String getProductName() {
		return productName;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	
	
}
