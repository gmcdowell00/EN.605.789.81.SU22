package io.swagger.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.swagger.dao.UserRepo;
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
}
