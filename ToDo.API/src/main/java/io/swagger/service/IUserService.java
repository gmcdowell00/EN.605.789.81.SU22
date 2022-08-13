package io.swagger.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.swagger.model.Movie;
import io.swagger.model.Task;
import io.swagger.model.UserAccount;

/**
 * Interface for user service
 * 
 * @authors Glenwood McDowell & Yaser Albonni
 *
 */
@Service
@Component(value = "userService")
public interface IUserService {

	UserAccount findByUserId(String userId);

	UserAccount findByUserIdPass(String userId, String password);

	Optional<User> FindByToken(String token);

	void insertUser(UserAccount user);

	String Login(String username, String password);

	public String createTask(String token, Task task);

	public String deleteTask(String token, String taskName);
	
	public String updateTask(String token, Task task);
	
	public String toggleCompleted(String token, String taskName);
	
	public Movie suggestMovie(String token);
}
