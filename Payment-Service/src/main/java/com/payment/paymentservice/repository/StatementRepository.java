package com.payment.paymentservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.paymentservice.model.Statement;

@Repository
public interface StatementRepository extends MongoRepository<Statement, Integer> {
	List<Statement> findByStatementId(int statementId);
}
