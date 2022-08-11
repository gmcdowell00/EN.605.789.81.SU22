package io.swagger.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.User;

@Repository(value="userRepo")
public interface UserRepo extends MongoRepository<User, String> {
	
	@Query("{ 'userId' : ?0 }")
	User findByUserId(String userId);
	
}
