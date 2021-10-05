package com.itp.importexport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeid;
	
	@Column(name = "employee_name")
	private String employeename;
	
	@Column(name = "employee_email")
	private String employeeemail;
	
	@Column(name = "employee_phone")
	private String employeephone;
	
	@Column(name = "employee_userName")
	private String employeeusername;
	
	@Column(name ="employee_password")
	private String employeepassword;
	
	@Column(name ="employee_address")
	private String employeeaddress;
	
	public Employee() {
	
	}
	
	
	public Employee(String employeename, String employeeemail, String employeephone, String employeeusername,
			String employeepassword, String employeeaddress) {
		super();
		this.employeename = employeename;
		this.employeeemail = employeeemail;
		this.employeephone = employeephone;
		this.employeeusername = employeeusername;
		this.employeepassword = employeepassword;
		this.employeeaddress = employeeaddress;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeeemail() {
		return employeeemail;
	}
	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}
	public String getEmployeephone() {
		return employeephone;
	}
	public void setEmployeephone(String employeephone) {
		this.employeephone = employeephone;
	}
	public String getEmployeeusername() {
		return employeeusername;
	}
	public void setEmployeeusername(String employeeusername) {
		this.employeeusername = employeeusername;
	}
	public String getEmployeepassword() {
		return employeepassword;
	}
	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}
	public String getEmployeeaddress() {
		return employeeaddress;
	}
	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}
	
	
	
	
}
	

