package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.NotBlank;

public class CustomerLoginDto {
	@NotBlank
private String email;
	@NotBlank
private String password;
	
	
	public CustomerLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerLoginDto(@NotBlank String email, @NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "AdminLoginDto [email=" + email + ", password=" + password + "]";
	}
	
	

}
