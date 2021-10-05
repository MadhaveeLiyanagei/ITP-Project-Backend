package com.itp.importexport.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int userId;
		
		
		@Column(name = "password")
		 private String password;

		@Column(name = "role")
		 private String role;
		
		public User() {
			
		}
		

		public User( String password, String role) {
			super();
			this.password = password;
			this.role = role;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}
		
		
		
		
}