package com.wip.insurance_Claim_System.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "claim_Status")
public class ClaimStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(length = 255)
    private String remarks;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

	public ClaimStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaimStatus(Long statusId, String status, String remarks, LocalDateTime updatedDate, Claim claim) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.remarks = remarks;
		this.updatedDate = updatedDate;
		this.claim = claim;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	@Override
	public String toString() {
		return "ClaimStatus [statusId=" + statusId + ", status=" + status + ", remarks=" + remarks + ", updatedDate="
				+ updatedDate + ", claim=" + claim + "]";
	}
    
    
}