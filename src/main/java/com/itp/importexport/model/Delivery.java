package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "delivery")
public class Delivery{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Order_Name")
	private String order_name;
	
	@Column(name = "Order_Address")
	private String order_address;
	
	@Column(name = "Order_Phone_Number")
	private int order_phone_number;
	
	public Delivery() {
		
	}

	

	public Delivery(long id, String order_name, String order_address, int order_phone_number) {
		super();
		this.id = id;
		this.order_name = order_name;
		this.order_address = order_address;
		this.order_phone_number = order_phone_number;
	}







	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public int getOrder_phone_number() {
		return order_phone_number;
	}

	public void setOrder_phone_number(int order_phone_number) {
		this.order_phone_number = order_phone_number;
	}
	
	
	

	
}