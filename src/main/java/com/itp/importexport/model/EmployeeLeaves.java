package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeLeaves")

public class EmployeeLeaves {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveNumber;
	
	@Column(name="employeeID")
	private String employeeID;
	
	@Column(name="adminID")
	private String adminID;
	
	@Column(name="date")
	private String date;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="status")
	private String status;
	
	
	public EmployeeLeaves() {
		
	}
	
	
	public EmployeeLeaves(String employeeID, String adminID, String date, String reason, String status) {
		super();
		this.employeeID = employeeID;
		this.adminID = adminID;
		this.date = date;
		this.reason = reason;
		this.status = status;
	}
	
	public int getLeaveNumber() {
		return leaveNumber;
	}
	
	public void setLeaveNumber(int leaveNumber) {
		this.leaveNumber = leaveNumber;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getAdminID() {
		return adminID;
	}
	
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
