package io.swagger.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.swagger.model.UserAccount;

@Service
@Component(value="userService")
public interface IUserService {
	
	UserAccount findByUserId(String userId);
	
	UserAccount findByUserIdPass(String userId, String password);
	
	//Optional<UserAccount> FindByToken(String token);
	Optional<User> FindByToken(String token);
	
	void insertUser(UserAccount user);
	
	String Login(String username, String password);

}
