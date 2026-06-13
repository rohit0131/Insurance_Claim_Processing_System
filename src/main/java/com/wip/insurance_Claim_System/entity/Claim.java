package com.wip.insurance_Claim_System.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "claim")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Long claimId;

    @Column(name = "claim_amount", nullable = false)
    private Double claimAmount;

    @Column(name = "claim_date")
    private LocalDate claimDate;

    @Column(length = 500)
    private String description;

    @Column(length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
}
