package com.wip.insurance_Claim_System.util;

import com.wip.insurance_Claim_System.dto.ClaimStatusDto;
import com.wip.insurance_Claim_System.entity.ClaimStatus;

public class ClaimStatusConverter {

    public static ClaimStatusDto toDto(ClaimStatus status) {

        ClaimStatusDto dto = new ClaimStatusDto();

        dto.setStatusId(status.getStatusId());
        dto.setClaimStatus(status.getStatus());
        dto.setRemarks(status.getRemarks());
        dto.setUpdatedDate(status.getUpdatedDate());

        return dto;
    }

    public static ClaimStatus toEntity(ClaimStatusDto dto) {

        ClaimStatus status = new ClaimStatus();

        status.setStatus(dto.getClaimStatus());
        status.setRemarks(dto.getRemarks());
        status.setUpdatedDate(dto.getUpdatedDate());

        return status;
    }
}