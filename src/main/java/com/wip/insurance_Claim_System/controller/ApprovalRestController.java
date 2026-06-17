package com.wip.insurance_Claim_System.controller;

import com.wip.insurance_Claim_System.dto.ApprovalDto;
import com.wip.insurance_Claim_System.service.ApprovalService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approval")
public class ApprovalRestController {

    @Autowired
    private ApprovalService approvalService;

    // APPROVE CLAIM
    @PostMapping("/addApproval")
    public ResponseEntity<?> approveClaim(@Valid @RequestBody ApprovalDto approvalDto) {

       approvalService.saveApproval(approvalDto);

       return new ResponseEntity<>(
               "Admin " + approvalDto.getApprovalId() + " created successfully",
               HttpStatus.OK
       );
    }

    @PutMapping("/updateApproval")
    public ResponseEntity<List<ApprovalDto>> updateApproval(
            @RequestBody ApprovalDto approvalDto) {

        List<ApprovalDto> updatedList = approvalService.updateApproval(approvalDto);

        return new ResponseEntity<>(updatedList, HttpStatus.OK);
    }

    // GET ALL APPROVALS
    @GetMapping("/getAllApprovals")
    public ResponseEntity<List<ApprovalDto>> getAllApprovals() {

        List<ApprovalDto> list = approvalService.getAllApprovals();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // GET APPROVAL BY ID
    @GetMapping("/getApproval/{id}")
    public ResponseEntity<ApprovalDto> getApproval(@PathVariable Long id) {

        ApprovalDto approval = approvalService.getApprovalById(id);

        return new ResponseEntity<>(approval, HttpStatus.OK);
    }
}