package io.swagger.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.swagger.model.User;

@Service
@Component(value="userService")
public interface IUserService {
	
	void insertUser(User user);
	
	User findByUserId(String userId);

}
