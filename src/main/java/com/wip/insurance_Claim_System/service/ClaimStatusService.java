package com.wip.insurance_Claim_System.service;


import com.wip.insurance_Claim_System.dto.ClaimStatusDto;

import java.util.List;

public interface ClaimStatusService {

    void saveClaimStatus(ClaimStatusDto claimStatusDto);

    ClaimStatusDto getClaimStatusById(Long statusId);

    List<ClaimStatusDto> getAllClaimStatus();

  List <ClaimStatusDto> updateClaimStatus(  ClaimStatusDto claimStatusDto);

  List <ClaimStatusDto> deleteClaimStatus(Long statusId);
}
