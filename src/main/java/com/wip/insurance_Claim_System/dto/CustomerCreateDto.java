package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerCreateDto {
	private Long customerId;

    @NotBlank(message = "Customer name is required")
    @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotBlank(message = "PassWord is required")
    @Email(message = "Invalid password format")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone number must contain exactly 10 digits"
    )
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;

	public CustomerCreateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerCreateDto(Long customerId,
			@NotBlank(message = "Customer name is required") @Size(min = 3, max = 60, message = "Name must be between 3 and 60 characters") String name,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@NotBlank(message = "PassWord is required") @Email(message = "Invalid password format") String password,
			@NotBlank(message = "Phone number is required") @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits") String phone,
			@NotBlank(message = "Address is required") String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerCreateDto [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + "]";
	}

    
}
