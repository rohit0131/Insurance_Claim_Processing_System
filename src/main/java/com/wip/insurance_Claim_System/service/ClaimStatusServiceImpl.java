package com.wip.insurance_Claim_System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.insurance_Claim_System.dto.ClaimStatusDto;
import com.wip.insurance_Claim_System.entity.ClaimStatus;
import com.wip.insurance_Claim_System.exception.ResourceNotFoundException;
import com.wip.insurance_Claim_System.repository.ClaimStatusRepository;
import com.wip.insurance_Claim_System.util.ClaimStatusConverter;

@Service
public class ClaimStatusServiceImpl implements ClaimStatusService {

    @Autowired
    private ClaimStatusRepository claimStatusRepository;

    // ADD STATUS (TRACK CLAIM)
    @Override
    public void saveClaimStatus(ClaimStatusDto dto) {

        ClaimStatus status = ClaimStatusConverter.toEntity(dto);
        claimStatusRepository.save(status);

        System.out.println("Claim Status Added...");
    }

    // GET ALL STATUS
    @Override
    public List<ClaimStatusDto> getAllClaimStatus() {

        List<ClaimStatus> list = claimStatusRepository.findAll();

        return list.stream()
                .map(ClaimStatusConverter::toDto)
                .collect(Collectors.toList());
    }

    // GET STATUS BY ID
    @Override
    public ClaimStatusDto getClaimStatusById(Long id) {

        ClaimStatus status = claimStatusRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ClaimStatus", "historyId", id));

        return ClaimStatusConverter.toDto(status);
    }

    // UPDATE STATUS
    @Override
    public List<ClaimStatusDto> updateClaimStatus(ClaimStatusDto dto) {

        ClaimStatus status = claimStatusRepository.findById(dto.getStatusId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("ClaimStatus", "historyId", dto.getStatusId()));

        status.setStatus(dto.getClaimStatus());
        status.setRemarks(dto.getRemarks());
        status.setUpdatedDate(dto.getUpdatedDate());

        claimStatusRepository.save(status);

        return getAllClaimStatus();
    }

    // DELETE STATUS
    @Override
    public List<ClaimStatusDto> deleteClaimStatus(Long id) {

        claimStatusRepository.deleteById(id);

        return getAllClaimStatus();
    }
}