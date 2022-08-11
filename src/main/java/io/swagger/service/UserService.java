package io.swagger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;

import io.swagger.dao.UserRepo;
import io.swagger.model.Task;
import io.swagger.model.Token;
import io.swagger.model.UserAccount;

@Service(value="userService")
public class UserService implements IUserService {

	@Qualifier(value="userRepo")
	private final UserRepo userRepo;
	
	@org.springframework.beans.factory.annotation.Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}	
	
	public UserAccount findByUserIdPass(String userId, String password) {
		return this.userRepo.findByUserIdPass(userId, password);
	}
	
	public List<Task> findUserTaskByToken(String token) {
		UserAccount user = this.userRepo.findTaskByToken(token);
		return user != null ? user.getTasks() : new ArrayList<Task>();
	}

	public void insertUser(UserAccount user) {
		this.userRepo.insert(user);
	}
	
	@Override
	public UserAccount findByUserId(String userId) {
		return this.userRepo.findByUserId(userId);		
	}
	
	@Override
	public Optional<User> FindByToken(String token) {
		
		if (token == null || token.equals(""))
			return Optional.empty();
		
		Optional<UserAccount> userAccount= userRepo.findByToken(token);
        if(userAccount.isPresent()){
                	
            UserAccount user = userAccount.get();
                      
            User userDetails = new User(user.getUserId(), user.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(userDetails);
        }
        return Optional.empty();
	}
	
	@Override
	public String Login(String username, String password) {
		
		Optional<UserAccount> userAccount = this.userRepo.login(username, password);
		
		if (userAccount.isPresent()) {
			
			UserAccount user = userAccount.get();
			
			if (user.getToken() != null)
			{
				String tokens = user.getToken().getToken();
				if (user.getToken().getToken() != null && !user.getToken().getToken().isBlank() && !user.getToken().getToken().isEmpty())
					return user.getToken().getToken();
				 
				Token token = new Token();
				LocalDate date = LocalDate.now();
				token.setToken(UUID.randomUUID().toString());
				token.setRefreshToken(UUID.randomUUID().toString());				
				token.setIssueDate(date);
				token.setExpirationDate(date.plusMonths(1));
				
				user.setToken(token);
				this.userRepo.save(user);
				return token.getToken();				
			}			
		}
		return StringUtils.EMPTY;
	}
}
