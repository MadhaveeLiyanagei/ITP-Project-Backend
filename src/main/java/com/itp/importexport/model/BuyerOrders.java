package com.itp.importexport.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BuyerOrders")
public class BuyerOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="UserName")
	private String username;
	
	@Column(name ="Address")
	private String address;
	
	@Column(name ="Email")
	private String email;
	
	@Column(name ="Contact")
	private String contact;
	
	@Column(name ="Date")
	private Date date;
	
	public BuyerOrders() {
		
	}
	
	public BuyerOrders(String username, String address, String email, String contact, Date date) {
		super();
		this.username = username;
		this.address = address;
		this.email = email;
		this.contact = contact;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
