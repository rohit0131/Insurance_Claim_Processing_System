package com.wip.insurance_Claim_System.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "claim_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(length = 255)
    private String remarks;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;
}