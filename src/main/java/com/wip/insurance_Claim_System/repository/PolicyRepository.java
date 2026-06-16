package com.wip.insurance_Claim_System.repository;

import com.wip.insurance_Claim_System.entity.Policy;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
