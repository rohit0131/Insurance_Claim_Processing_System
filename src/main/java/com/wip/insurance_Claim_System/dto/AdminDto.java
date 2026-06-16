package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AdminDto {

    private Long adminId;

    @NotBlank(message = "Admin Name is required")
    private String adminName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Role is required")
    private String role;

	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDto(Long adminId, @NotBlank(message = "Admin Name is required") String adminName,
			@NotBlank(message = "Email is required") @Email(message = "Invalid Email") String email,
			@NotBlank(message = "Role is required") String role) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.email = email;
		this.role = role;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", adminName=" + adminName + ", email=" + email + ", role=" + role
				+ "]";
	}
    
    
	
}