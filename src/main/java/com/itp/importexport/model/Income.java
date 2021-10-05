package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incomes")
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long incomeID;
	
	@Column(name = "transaction")
	private String transaction;
	
	@Column(name = "payment_from")
	private String paymentFrom;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "income_category")
	private String incomeCategory;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private double amount;

	public Income() {
	
	}

	public Income(String transaction, String paymentFrom, String date, String incomeCategory, String description,
			double amount) {
		super();
		this.transaction = transaction;
		this.paymentFrom = paymentFrom;
		this.date = date;
		this.incomeCategory = incomeCategory;
		this.description = description;
		this.amount = amount;
	}
	
	
	public long getIncomeID() {
		return incomeID;
	}
	public void setIncomeID(long incomeID) {
		this.incomeID = incomeID;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public String getPaymentFrom() {
		return paymentFrom;
	}
	public void setPaymentFrom(String paymentFrom) {
		this.paymentFrom = paymentFrom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIncomeCategory() {
		return incomeCategory;
	}
	public void setIncomeCategory(String incomeCategory) {
		this.incomeCategory = incomeCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
  
}
