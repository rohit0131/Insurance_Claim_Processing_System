package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.PolicyDto;

import java.util.List;

public interface PolicyService {

    void savePolicy(PolicyDto policyDto);

    PolicyDto getPolicyById(Long policyId);

    List<PolicyDto> getAllPolicies();

   List<PolicyDto> updatePolicy( PolicyDto policyDto);

   List<PolicyDto> deletePolicy(Long policyId);
}
