package io.swagger.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.UserAccount;

@Repository(value="userRepo")
public interface UserRepo extends MongoRepository<UserAccount, String> {
	
	@Query("{ 'userId' : ?0, 'password' : ?1 }")
	UserAccount findByUserIdPass(String userId, String password);
	
	@Query("{ 'token.token' : ?0}")
	UserAccount findTaskByToken(String token);
	
	@Query("{ 'userId' : ?0 }")
	UserAccount findByUserId(String userId);
	
	@Query("{ 'token.token' : ?0 }")
	Optional<UserAccount> findByToken (String token);
	
	@Query("{ 'userId' : ?0, 'password' : ?1}")
	Optional<UserAccount> login (String userId, String password);
	
}
