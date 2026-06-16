package com.wip.insurance_Claim_System.util;

import com.wip.insurance_Claim_System.dto.PolicyDto;
import com.wip.insurance_Claim_System.entity.Policy;

public class PolicyConverter {

    public static PolicyDto toDto(Policy policy) {

        PolicyDto dto = new PolicyDto();

        dto.setPolicyId(policy.getPolicyId());
        dto.setPolicyNo(policy.getPolicyNo());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());

        return dto;
    }

    public static Policy toEntity(PolicyDto dto) {

        Policy policy = new Policy();

        policy.setPolicyNo(dto.getPolicyNo());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        return policy;
    }
}