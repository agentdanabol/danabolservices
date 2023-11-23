package com.danabol.fraud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudCheckHistoryRepository extends MongoRepository<FraudCheckHistory, String> {

    List<FraudCheckHistory> findAllByCustomerId (int id);

}
