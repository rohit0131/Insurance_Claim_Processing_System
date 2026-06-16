package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class ApprovalDto {

    private Long approvalId;

    @NotBlank(message = "Decision is required")
    private String status;

    private String comments;

    @NotNull(message = "Approval Date is required")
    private LocalDateTime approvalDate;

    @NotNull(message = "Claim Id is required")
    private Long claimId;

    @NotNull(message = "Admin Id is required")
    private Long adminId;

	public ApprovalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalDto(Long approvalId, @NotBlank(message = "Decision is required") String status, String comments,
			@NotNull(message = "Approval Date is required") LocalDateTime approvalDate,
			@NotNull(message = "Claim Id is required") Long claimId,
			@NotNull(message = "Admin Id is required") Long adminId) {
		super();
		this.approvalId = approvalId;
		this.status = status;
		this.comments = comments;
		this.approvalDate = approvalDate;
		this.claimId = claimId;
		this.adminId = adminId;
	}

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDateTime getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDateTime approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "ApprovalDto [approvalId=" + approvalId + ", Status=" + status + ", comments=" + comments
				+ ", approvalDate=" + approvalDate + ", claimId=" + claimId + ", adminId=" + adminId + "]";
	}
    
    
}