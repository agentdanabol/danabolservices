package com.danabol.fraud;

import com.danabol.fraud.dto.FraudCheckHistoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.insert(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

    public List<FraudCheckHistoryResponse> getAllByCustomer(Integer customerId) {
        List<FraudCheckHistory> list = fraudCheckHistoryRepository.findAllByCustomerId(customerId);
        List<FraudCheckHistoryResponse> responses = new ArrayList<>();
        for (FraudCheckHistory fraudCheckHistory : list) {
            responses.add(
                    FraudCheckHistoryResponse.builder()
                    .id(fraudCheckHistory.getId())
                    .isFraudster(fraudCheckHistory.getIsFraudster())
                    .customerId(fraudCheckHistory.getCustomerId())
                    .createdAt(fraudCheckHistory.getCreatedAt())
                    .build()
            );
        }
        return responses;
    }

}
