package com.wip.insurance_Claim_System.util;

import com.wip.insurance_Claim_System.dto.ApprovalDto;
import com.wip.insurance_Claim_System.entity.Approval;

public class ApprovalConverter {

    public static ApprovalDto toDto(Approval approval) {

        ApprovalDto dto = new ApprovalDto();

        dto.setApprovalId(approval.getApprovalId());
        dto.setStatus(approval.getStatus());
        dto.setApprovalDate(approval.getApprovalDate());

        return dto;
    }

    public static Approval toEntity(ApprovalDto dto) {

        Approval approval = new Approval();

        approval.setStatus(dto.getStatus());
        approval.setApprovalDate(dto.getApprovalDate());

        return approval;
    }
}