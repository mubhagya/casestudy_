package com.green.car.wash.washer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.green.car.wash.washer.model.WashPacks;

                                                     //WasherProfile
public interface WashPackRepo extends MongoRepository<WashPacks, Integer> {
	
}
