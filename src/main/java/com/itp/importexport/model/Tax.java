package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxes")
public class Tax {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long taxID;
	  
	  @Column(name = "product_id")
	  private String productID;
	  
	  @Column(name = "country_code")
	  private String countryCode;
	  
	  @Column(name = "pre_tax_price")
	  private double preTaxPrice;
	  
	  @Column(name = "tax_rate")
	  private String taxRate;
	  
	  @Column(name = "sub_total")
	  private double subTotal;
	  
	  @Column(name = "vat")
	  private String vat;
	  
	  @Column(name = "total_price")
	  private double totalPrice;
	  
	public Tax() {
		
	}

	
	
	public Tax(String productID, String countryCode, double preTaxPrice, String taxRate, double subTotal, String vat,
			double totalPrice) {
		super();
		this.productID = productID;
		this.countryCode = countryCode;
		this.preTaxPrice = preTaxPrice;
		this.taxRate = taxRate;
		this.subTotal = subTotal;
		this.vat = vat;
		this.totalPrice = totalPrice;
	}



	public long getTaxID() {
		return taxID;
	}

	public void setTaxID(long taxID) {
		this.taxID = taxID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getPreTaxPrice() {
		return preTaxPrice;
	}

	public void setPreTaxPrice(double preTaxPrice) {
		this.preTaxPrice = preTaxPrice;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public String getVAT() {
		return vat;
	}

	public void setVAT(String vat) {
		this.vat = vat;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	  
	
	
	  
	 
	  

}
