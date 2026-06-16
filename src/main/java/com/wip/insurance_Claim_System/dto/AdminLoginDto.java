package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.NotBlank;

public class AdminLoginDto {
	@NotBlank
private String email;
	@NotBlank
private String password;
	
	
	public AdminLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdminLoginDto(@NotBlank String email, @NotBlank String password) {
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
