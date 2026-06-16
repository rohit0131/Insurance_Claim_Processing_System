package com.wip.insurance_Claim_System.util;

import com.wip.insurance_Claim_System.dto.ClaimDto;
import com.wip.insurance_Claim_System.entity.Claim;

public class ClaimConverter {

    public static ClaimDto toDto(Claim claim) {

        ClaimDto dto = new ClaimDto();

        dto.setClaimId(claim.getClaimId());
        dto.setClaimAmount(claim.getClaimAmount());
        dto.setClaimDate(claim.getClaimDate());
        dto.setDescription(claim.getDescription());
        dto.setStatus(claim.getStatus());

        return dto;
    }

    public static Claim toEntity(ClaimDto dto) {

        Claim claim = new Claim();

        claim.setClaimAmount(dto.getClaimAmount());
        claim.setClaimDate(dto.getClaimDate());
        claim.setDescription(dto.getDescription());
        claim.setStatus(dto.getStatus());

        return claim;
    }
}