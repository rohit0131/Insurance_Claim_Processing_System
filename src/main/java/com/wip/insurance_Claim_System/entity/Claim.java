package com.wip.insurance_Claim_System.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "claim")

public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Long claimId;

    @Column(name = "claim_amount", nullable = false)
    private Double claimAmount;

    @Column(name = "claim_date")
    private LocalDate claimDate;

    @Column(length = 500)
    private String description;

    @Column(length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(Long claimId, Double claimAmount, LocalDate claimDate, String description, String status,
			Policy policy) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.description = description;
		this.status = status;
		this.policy = policy;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", description=" + description + ", status=" + status + ", policy=" + policy + "]";
	}
    
}
