package com.app.entities;

import java.sql.Date;


public class User {
	private String fn;
	private String ln;
	private String email;
	private String pass;
	private Date dob;
	private boolean status;
	private String role;
	
	public User(String fn, String ln, String email, String pass, Date dob, String role) {
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.pass = pass;
		this.dob = dob;
		this.status = false;
		this.role = role;
	}


	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
