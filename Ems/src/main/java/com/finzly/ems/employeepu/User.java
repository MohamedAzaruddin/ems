package com.finzly.ems.employeepu;

// Generated 27 May, 2020 11:20:36 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "ems")
public class User implements java.io.Serializable {

	private String name;
	private String password;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Id
	@Column(name = "name", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
