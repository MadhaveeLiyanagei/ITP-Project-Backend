package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SupplierOrder")

public class SupplierOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="Supplier_Name")
	private String supplierName;
	
	@Column(name ="Company_Name")
	private String companyName;
	
	@Column(name ="Company_Address")
	private String companyAddress;
	
	@Column(name ="Supplier_Contact")
	private String supplierContact;
	
	@Column(name ="Company_Email")
	private String companyEmail;

	@Column(name ="Description")
	private String description;

	public SupplierOrder() {

	}

	public SupplierOrder(int id, String supplierName, String companyName, String companyAddress, String supplierContact, String companyEmail, String description) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.supplierContact = supplierContact;
		this.companyEmail = companyEmail;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getSupplierContact() {
		return supplierContact;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
