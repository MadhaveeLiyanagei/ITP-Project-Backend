package com.itp.importexport.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "product")

 

public class Product{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID; 
    
    @Column(name = "productImage")
    private String productImage; 
    
    @Column(name = "productName")
    private String productName; 
    
    @Column(name = "pDetails")
    private String productDetails; 
    
    @Column(name = "productPrice")
    private int productPrice;

	public Product() {
		super();
	}

	public Product(String productImage, String productName, String productDetails, int productPrice) {
		super();
		this.productImage = productImage;
		this.productName = productName;
		this.productDetails = productDetails;
		this.productPrice = productPrice;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	
    
}
