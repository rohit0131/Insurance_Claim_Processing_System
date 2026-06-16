package com.wip.insurance_Claim_System.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.insurance_Claim_System.dto.ApprovalDto;
import com.wip.insurance_Claim_System.entity.Approval;
import com.wip.insurance_Claim_System.exception.ResourceNotFoundException;
import com.wip.insurance_Claim_System.repository.ApprovalRepository;
import com.wip.insurance_Claim_System.util.ApprovalConverter;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    // SAVE APPROVAL
    @Override
    public void saveApproval(ApprovalDto approvalDto) {

        Approval approval = ApprovalConverter.toEntity(approvalDto);

        // business logic default
        if (approval.getApprovalDate() == null) {
            approval.setApprovalDate(LocalDateTime.now());
        }

        if (approval.getStatus() == null) {
            approval.setStatus("PENDING");
        }

        approvalRepository.save(approval);

        System.out.println("Approval Saved...");
    }

    // GET BY ID
    @Override
    public ApprovalDto getApprovalById(Long approvalId) {

        Approval approval = approvalRepository.findById(approvalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approval", "approvalId", approvalId));

        return ApprovalConverter.toDto(approval);
    }

    // GET ALL
    @Override
    public List<ApprovalDto> getAllApprovals() {

        List<Approval> list = approvalRepository.findAll();

        return list.stream()
                .map(ApprovalConverter::toDto)
                .collect(Collectors.toList());
    }

    // UPDATE APPROVAL
    @Override
    public List<ApprovalDto> updateApproval(ApprovalDto approvalDto) {

        Approval approval = approvalRepository.findById(approvalDto.getApprovalId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approval", "approvalId", approvalDto.getApprovalId()));

        approval.setStatus(approvalDto.getStatus());
        approval.setComments(approvalDto.getComments());
        approval.setApprovalDate(LocalDateTime.now());

        approvalRepository.save(approval);

        return getAllApprovals();
    }

    // DELETE APPROVAL
    @Override
    public List<ApprovalDto> deleteApproval(Long approvalId) {

        Approval approval = approvalRepository.findById(approvalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approval", "approvalId", approvalId));

        approvalRepository.delete(approval);

        return getAllApprovals();
    }
}