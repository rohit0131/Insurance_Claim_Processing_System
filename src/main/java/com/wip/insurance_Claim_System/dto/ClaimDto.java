package com.wip.insurance_Claim_System.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


public class ClaimDto {

    private Long claimId;

    @NotNull(message = "Claim amount is required")
    @Positive(message = "Claim amount must be greater than zero")
    private Double claimAmount;

    @NotNull(message = "Claim date is required")
    private LocalDate claimDate;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Policy Id is required")
    private Long policyId;

	public ClaimDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaimDto(Long claimId,
			@NotNull(message = "Claim amount is required") @Positive(message = "Claim amount must be greater than zero") Double claimAmount,
			@NotNull(message = "Claim date is required") LocalDate claimDate,
			@NotBlank(message = "Description is required") String description,
			@NotBlank(message = "Status is required") String status,
			@NotNull(message = "Policy Id is required") Long policyId) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
		this.description = description;
		this.status = status;
		this.policyId = policyId;
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

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	@Override
	public String toString() {
		return "ClaimDto [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimDate=" + claimDate
				+ ", description=" + description + ", status=" + status + ", policyId=" + policyId + "]";
	}
    
    
}
