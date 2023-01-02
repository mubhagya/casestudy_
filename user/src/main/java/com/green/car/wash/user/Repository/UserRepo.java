package com.green.car.wash.user.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.user.model.User1;


@Repository
public interface UserRepo extends MongoRepository<User1, String> {

	User1 findByUsername(String username);

}
