package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierid;
	
	@Column(name = "supplier_name")
	private String suppliername;
	
	@Column(name = "supplier_email")
	private String supplieremail;
	
	@Column(name = "supplier_phone")
	private String supplierphone;
	
	@Column(name = "supplier_userName")
	private String supplierusername;
	
	@Column(name ="supplier_password")
	private String supplierpassword;
	
	@Column(name ="supplier_address")
	private String supplieraddress;
	
	public Supplier() {
		
	}
	
	
	public Supplier(String suppliername, String supplieremail, String supplierphone, String supplierusername,
			String supplierpassword, String supplieraddress) {
		super();
		this.suppliername = suppliername;
		this.supplieremail = supplieremail;
		this.supplierphone = supplierphone;
		this.supplierusername = supplierusername;
		this.supplierpassword = supplierpassword;
		this.supplieraddress = supplieraddress;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplieremail() {
		return supplieremail;
	}
	public void setSupplieremail(String supplieremail) {
		this.supplieremail = supplieremail;
	}
	public String getSupplierphone() {
		return supplierphone;
	}
	public void setSupplierphone(String supplierphone) {
		this.supplierphone = supplierphone;
	}
	public String getSupplierusername() {
		return supplierusername;
	}
	public void setSupplierusername(String supplierusername) {
		this.supplierusername = supplierusername;
	}
	public String getSupplierpassword() {
		return supplierpassword;
	}
	public void setSupplierpassword(String supplierpassword) {
		this.supplierpassword = supplierpassword;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	
	
}
	