package com.danabol.fraud;

import com.danabol.fraud.dto.FraudCheckHistoryResponse;
import com.danabol.fraud.dto.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "/check/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

    @GetMapping(path = "{customerId}")
    public List<FraudCheckHistoryResponse> getAllCustomerChecks(@PathVariable Integer customerId) {
        return fraudCheckService.getAllByCustomer(customerId);
    }

}
