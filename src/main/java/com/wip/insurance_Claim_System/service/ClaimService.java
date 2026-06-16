package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.ClaimDto;

import java.util.List;

public interface ClaimService {

    void saveClaim(ClaimDto claimDto);

    ClaimDto getClaimById(Long claimId);

    List<ClaimDto> getAllClaims();

   List <ClaimDto> updateClaim( ClaimDto claimDto);

   List <ClaimDto> deleteClaim(Long claimId);
}
