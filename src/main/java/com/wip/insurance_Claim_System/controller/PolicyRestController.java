package com.wip.insurance_Claim_System.controller;

import com.wip.insurance_Claim_System.dto.PolicyDto;
import com.wip.insurance_Claim_System.service.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy")
public class PolicyRestController {

    @Autowired
    private PolicyService policyService;

    // SAVE POLICY
    @PostMapping("/addPolicy")
    public ResponseEntity<String> savePolicy(@RequestBody PolicyDto policyDto) {

        policyService.savePolicy(policyDto);

        return new ResponseEntity<>("Policy created successfully", HttpStatus.CREATED);
    }

    // GET POLICY BY ID
    @GetMapping("/getPolicy/{id}")
    public ResponseEntity<PolicyDto> getPolicyById(@PathVariable Long id) {

        PolicyDto dto = policyService.getPolicyById(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // GET ALL POLICIES
    @GetMapping("/getAllPolicies")
    public ResponseEntity<List<PolicyDto>> getAllPolicies() {

        List<PolicyDto> list = policyService.getAllPolicies();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // UPDATE POLICY
    @PutMapping("/updatePolicy")
    public ResponseEntity<List<PolicyDto>> updatePolicy(@RequestBody PolicyDto policyDto) {

        List<PolicyDto> updatedList = policyService.updatePolicy(policyDto);

        return new ResponseEntity<>(updatedList, HttpStatus.OK);
    }

    // DELETE POLICY
    @DeleteMapping("/deletePolicy/{id}")
    public ResponseEntity<List<PolicyDto>> deletePolicy(@PathVariable Long id) {

        List<PolicyDto> list = policyService.deletePolicy(id);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}