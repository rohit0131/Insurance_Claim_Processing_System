package com.wip.insurance_Claim_System.controller;

import com.wip.insurance_Claim_System.dto.ClaimDto;
import com.wip.insurance_Claim_System.service.ClaimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claim")
public class ClaimRestController {

    @Autowired
    private ClaimService claimService;

    // SAVE CLAIM
    @PostMapping("/addClaim")
    public ResponseEntity<String> saveClaim(@RequestBody ClaimDto claimDto) {

        claimService.saveClaim(claimDto);

        return new ResponseEntity<>("Claim submitted successfully", HttpStatus.CREATED);
    }

    // GET CLAIM BY ID
    @GetMapping("/getClaim/{id}")
    public ResponseEntity<ClaimDto> getClaimById(@PathVariable Long id) {

        ClaimDto dto = claimService.getClaimById(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // GET ALL CLAIMS
    @GetMapping("/getAllClaims")
    public ResponseEntity<List<ClaimDto>> getAllClaims() {

        List<ClaimDto> list = claimService.getAllClaims();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // UPDATE CLAIM
    @PutMapping("/updateClaim")
    public ResponseEntity<List<ClaimDto>> updateClaim(@RequestBody ClaimDto claimDto) {

        List<ClaimDto> updatedList = claimService.updateClaim(claimDto);

        return new ResponseEntity<>(updatedList, HttpStatus.OK);
    }

    // DELETE CLAIM
    @DeleteMapping("/deleteClaim/{id}")
    public ResponseEntity<List<ClaimDto>> deleteClaim(@PathVariable Long id) {

        List<ClaimDto> list = claimService.deleteClaim(id);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}