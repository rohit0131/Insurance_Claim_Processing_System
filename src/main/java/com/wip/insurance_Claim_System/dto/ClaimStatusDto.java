package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class ClaimStatusDto {

    private Long statusId;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Remarks are required")
    private String remarks;

    @NotNull(message = "Updated date is required")
    private LocalDateTime updatedDate;

    @NotNull(message = "Claim Id is required")
    private Long claimId;

	public ClaimStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaimStatusDto(Long statusId, @NotBlank(message = "Status is required") String status,
			@NotBlank(message = "Remarks are required") String remarks,
			@NotNull(message = "Updated date is required") LocalDateTime updatedDate,
			@NotNull(message = "Claim Id is required") Long claimId) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.remarks = remarks;
		this.updatedDate = updatedDate;
		this.claimId = claimId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long historyId) {
		this.statusId = historyId;
	}

	public String getClaimStatus() {
		return status;
	}

	public void setClaimStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	@Override
	public String toString() {
		return "ClaimStatusDto [statusId=" + statusId + ", status=" + status + ", remarks=" + remarks
				+ ", updatedDate=" + updatedDate + ", claimId=" + claimId + "]";
	}
    
    
	
}
