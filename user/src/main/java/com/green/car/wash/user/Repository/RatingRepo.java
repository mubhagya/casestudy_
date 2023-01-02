package com.green.car.wash.user.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.green.car.wash.user.model.Ratings;

public interface RatingRepo extends MongoRepository<Ratings, Integer> {

}
