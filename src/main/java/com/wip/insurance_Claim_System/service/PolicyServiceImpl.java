package com.wip.insurance_Claim_System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.insurance_Claim_System.dto.PolicyDto;
import com.wip.insurance_Claim_System.entity.Policy;
import com.wip.insurance_Claim_System.exception.ResourceNotFoundException;
import com.wip.insurance_Claim_System.repository.PolicyRepository;
import com.wip.insurance_Claim_System.util.PolicyConverter;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    // CREATE POLICY
    @Override
    public void savePolicy(PolicyDto policyDto) {

        Policy policy = PolicyConverter.toEntity(policyDto);
        policyRepository.save(policy);

        System.out.println("Policy Created...");
    }

    // GET ALL POLICIES
    @Override
    public List<PolicyDto> getAllPolicies() {

        List<Policy> policies = policyRepository.findAll();

        return policies.stream()
                .map(PolicyConverter::toDto)
                .collect(Collectors.toList());
    }

    // GET POLICY BY ID
    @Override
    public PolicyDto getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy", "policyId", id));

        return PolicyConverter.toDto(policy);
    }

    // UPDATE POLICY
    @Override
    public List<PolicyDto> updatePolicy(PolicyDto policyDto) {

        Policy policy = policyRepository.findById(policyDto.getPolicyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy", "policyId", policyDto.getPolicyId()));

        policy.setPolicyNo(policyDto.getPolicyNo());
        policy.setPolicyType(policyDto.getPolicyType());
        policy.setPremiumAmount(policyDto.getPremiumAmount());
        policy.setStartDate(policyDto.getStartDate());
        policy.setEndDate(policyDto.getEndDate());

        policyRepository.save(policy);

        return getAllPolicies();
    }

    // DELETE POLICY
    @Override
    public List<PolicyDto> deletePolicy(Long id) {

        policyRepository.deleteById(id);

        return getAllPolicies();
    }
}