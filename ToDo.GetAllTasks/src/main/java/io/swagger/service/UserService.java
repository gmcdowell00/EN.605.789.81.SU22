package io.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.swagger.dao.UserRepo;
import io.swagger.model.Task;
import io.swagger.model.User;

@Service(value="userService")
public class UserService implements IUserService {

	@Qualifier(value="userRepo")
	private final UserRepo userRepo;
	
	@org.springframework.beans.factory.annotation.Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}	
	
	public User findByUserIdPass(String userId, String password) {
		return this.userRepo.findByUserIdPass(userId, password);
	}
	
	public List<Task> findUserTaskByToken(String token) {
		User user = this.userRepo.findTaskByToken(token);
		return user != null ? user.getTasks() : new ArrayList<Task>();
	}
}
