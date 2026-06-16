package com.wip.insurance_Claim_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "approval")

public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id")
    private Long approvalId;

    @Column(nullable = false, length = 20)
    private String status; // APPROVED / REJECTED

    @Column(length = 255)
    private String comments;

    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(Long approvalId, String status, String comments, LocalDateTime approvalDate, Claim claim,
			Admin admin) {
		super();
		this.approvalId = approvalId;
		this.status = status;
		this.comments = comments;
		this.approvalDate = approvalDate;
		this.claim = claim;
		this.admin = admin;
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

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", status=" + status + ", comments=" + comments
				+ ", approvalDate=" + approvalDate + ", claim=" + claim + ", admin=" + admin + "]";
	}
    
    
}