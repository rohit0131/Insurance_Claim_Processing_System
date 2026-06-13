package com.wip.insurance_Claim_System.dto;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDto {

    private Long policyId;

    @NotBlank(message = "Policy number is required")
    private String policyNo;

    @NotBlank(message = "Policy type is required")
    private String policyType;

    @NotNull(message = "Premium amount is required")
    @Positive(message = "Premium amount must be greater than zero")
    private Double premiumAmount;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be a future date")
    private LocalDate endDate;

    @NotNull(message = "Customer Id is required")
    private Long customerId;
}
