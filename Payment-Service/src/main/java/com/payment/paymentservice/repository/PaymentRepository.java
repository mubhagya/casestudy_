package com.payment.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.payment.paymentservice.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Integer>{
	public Payment findByProfileId(int profileId);

}
