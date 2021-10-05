package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long expenseID;
	
	@Column(name = "transaction")
	private String transaction;
	
	@Column(name = "payment_to")
	private String paymentTo;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "expense_category")
	private String expenseCategory;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private double amount;

	public Expense() {
	
	}

	public Expense(String transaction, String paymentTo, String date, String expenseCategory, String description,
			double amount) {
		super();
		this.transaction = transaction;
		this.paymentTo = paymentTo;
		this.date = date;
		this.expenseCategory = expenseCategory;
		this.description = description;
		this.amount = amount;
	}
	
	
	public long getExpenseID() {
		return expenseID;
	}
	public void setExpenseID(long expenseID) {
		this.expenseID = expenseID;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public String getPaymentTo() {
		return paymentTo;
	}
	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
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
