package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requestOrder")
public class RequestOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestOrderID;
	
	@Column(name = "productID")
	private int productID;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "reOrder")
	private int reOrder;
	
	@Column(name = "description")
	private String description;
	
    public RequestOrder() {
		
	}

	public RequestOrder(int productID, String productName, int reOrder, String description) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.reOrder = reOrder;
		this.description = description;
	}

	public int getRequestOrderID() {
		return requestOrderID;
	}

	public void setRequestOrderID(int requestOrderID) {
		this.requestOrderID = requestOrderID;
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

	public int getReOrder() {
		return reOrder;
	}

	public void setReOrder(int reOrder) {
		this.reOrder = reOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
