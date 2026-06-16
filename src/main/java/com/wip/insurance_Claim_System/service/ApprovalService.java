package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.ApprovalDto;

import java.util.List;

public interface ApprovalService {

   void saveApproval(ApprovalDto approvalDto);

    ApprovalDto getApprovalById(Long approvalId);

    List<ApprovalDto> getAllApprovals();

   List<ApprovalDto> updateApproval( ApprovalDto approvalDto);

   List<ApprovalDto> deleteApproval(Long approvalId);
}