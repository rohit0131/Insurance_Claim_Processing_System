package com.wip.insurance_Claim_System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimStatusDto {

    private Long historyId;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Remarks are required")
    private String remarks;

    @NotNull(message = "Updated date is required")
    private LocalDateTime updatedDate;

    @NotNull(message = "Claim Id is required")
    private Long claimId;
}
