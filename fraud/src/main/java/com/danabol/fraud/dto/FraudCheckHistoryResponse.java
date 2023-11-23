package com.danabol.fraud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistoryResponse {
    private String id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
