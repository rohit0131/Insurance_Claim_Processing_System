package com.wip.insurance_Claim_System.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wip.insurance_Claim_System.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}