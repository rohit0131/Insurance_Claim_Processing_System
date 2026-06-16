package com.wip.insurance_Claim_System.dto;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class PolicyDto {

    private Long policyId;

    @NotBlank(message = "Policy number is required")
    private String policyNo;

    @NotBlank(message = "Policy type is required")
    private String policyType;

    @NotNull(message = "Premium amount is required")
    @Positive(message = "Premium amount must be greater than zero")
    private Double premiumAmount;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be a future date")
    private LocalDate endDate;

    @NotNull(message = "Customer Id is required")
    private Long customerId;

	public PolicyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PolicyDto(Long policyId, @NotBlank(message = "Policy number is required") String policyNo,
			@NotBlank(message = "Policy type is required") String policyType,
			@NotNull(message = "Premium amount is required") @Positive(message = "Premium amount must be greater than zero") Double premiumAmount,
			@NotNull(message = "Start date is required") LocalDate startDate,
			@NotNull(message = "End date is required") @Future(message = "End date must be a future date") LocalDate endDate,
			@NotNull(message = "Customer Id is required") Long customerId) {
		super();
		this.policyId = policyId;
		this.policyNo = policyNo;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customerId = customerId;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "PolicyDto [policyId=" + policyId + ", policyNo=" + policyNo + ", policyType=" + policyType
				+ ", premiumAmount=" + premiumAmount + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", customerId=" + customerId + "]";
	}
    
    
	
}
