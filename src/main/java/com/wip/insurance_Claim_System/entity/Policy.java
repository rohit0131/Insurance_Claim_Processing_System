package com.wip.insurance_Claim_System.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;

    @Column(name = "policy_no", nullable = false, unique = true)
    private String policyNo;

    @Column(name = "policy_type", nullable = false)
    private String policyType;

    @Column(name = "premium_amount")
    private Double premiumAmount;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
