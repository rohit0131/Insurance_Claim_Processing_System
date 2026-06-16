package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.ClaimDto;
import com.wip.insurance_Claim_System.entity.Claim;
import com.wip.insurance_Claim_System.exception.ResourceNotFoundException;
import com.wip.insurance_Claim_System.repository.ClaimRepository;
import com.wip.insurance_Claim_System.service.ClaimService;
import com.wip.insurance_Claim_System.util.ClaimConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public void saveClaim(ClaimDto dto) {
        claimRepository.save(ClaimConverter.toEntity(dto));
    }

    @Override
    public ClaimDto getClaimById(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim", "id", id));

        return ClaimConverter.toDto(claim);
    }

    @Override
    public List<ClaimDto> getAllClaims() {
        return claimRepository.findAll()
                .stream()
                .map(ClaimConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClaimDto> updateClaim(ClaimDto dto) {

        Claim claim = claimRepository.findById(dto.getClaimId())
                .orElseThrow(() -> new ResourceNotFoundException("Claim", "id", dto.getClaimId()));

        claim.setClaimAmount(dto.getClaimAmount());
        claim.setStatus(dto.getStatus());

        claimRepository.save(claim);

        return getAllClaims();
    }

    @Override
    public List<ClaimDto> deleteClaim(Long id) {
        claimRepository.deleteById(id);
        return getAllClaims();
    }
}