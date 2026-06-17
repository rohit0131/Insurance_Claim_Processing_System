package com.wip.insurance_Claim_System.controller;

import com.wip.insurance_Claim_System.dto.ClaimStatusDto;
import com.wip.insurance_Claim_System.service.ClaimStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class ClaimStatusRestController {

    @Autowired
    private ClaimStatusService claimStatusService;

    // SAVE CLAIM STATUS
    @PostMapping("/addStatus")
    public ResponseEntity<String> saveStatus(@RequestBody ClaimStatusDto dto) {

        claimStatusService.saveClaimStatus(dto);

        return new ResponseEntity<>("Claim status saved successfully", HttpStatus.CREATED);
    }

    // GET STATUS BY ID
    @GetMapping("/getStatus/{id}")
    public ResponseEntity<ClaimStatusDto> getStatusById(@PathVariable Long id) {

        ClaimStatusDto dto = claimStatusService.getClaimStatusById(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // GET ALL STATUSES
    @GetMapping("/getAllStatus")
    public ResponseEntity<List<ClaimStatusDto>> getAllStatus() {

        List<ClaimStatusDto> list = claimStatusService.getAllClaimStatus();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // UPDATE STATUS
    @PutMapping("/updateStatus")
    public ResponseEntity<List<ClaimStatusDto>> updateStatus(
            @RequestBody ClaimStatusDto dto) {

        List<ClaimStatusDto> updatedList = claimStatusService.updateClaimStatus(dto);

        return new ResponseEntity<>(updatedList, HttpStatus.OK);
    }

    // DELETE STATUS
    @DeleteMapping("/deleteStatus/{id}")
    public ResponseEntity<List<ClaimStatusDto>> deleteStatus(@PathVariable Long id) {

        List<ClaimStatusDto> list = claimStatusService.deleteClaimStatus(id);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}