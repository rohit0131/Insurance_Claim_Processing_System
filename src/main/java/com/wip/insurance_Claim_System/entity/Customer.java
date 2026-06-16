package com.wip.insurance_Claim_System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 10)
    private String phone;

    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Policy> policies;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String name, String password, String email, String phone, String address, List<Policy> policies) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.password=password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.policies = policies;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", policies=" + policies + "]";
	}

	
    
    
}