package io.swagger.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.dao.UserRepo;
import io.swagger.model.Movie;
import io.swagger.model.Showtime;
import io.swagger.model.Task;
import io.swagger.model.Token;
import io.swagger.model.UserAccount;
import io.swagger.model.moviesapi.Root;

/**
 * Implementation of user service
 * 
 * @authors Glenwood McDowell & Yaser Albonni
 *
 */
@Service(value = "userService")
public class UserService implements IUserService {

	@Qualifier(value = "userRepo")
	private final UserRepo userRepo;

	@org.springframework.beans.factory.annotation.Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public UserAccount findByUserIdPass(String userId, String password) {
		return this.userRepo.findByUserIdPass(userId, password);
	}

	public List<Task> findUserTaskByToken(String token) {
		Optional<UserAccount> user = this.userRepo.findByToken(token);
		return user.isPresent() ? user.get().getTasks() : new ArrayList<Task>();
	}

	public void insertUser(UserAccount user) {
		this.userRepo.insert(user);
	}

	@Override
	public UserAccount Save(UserAccount user) {
		return this.userRepo.save(user);
	}

	@Override
	public UserAccount findByUserId(String userId) {
		return this.userRepo.findByUserId(userId);
	}

	@Override
	public Optional<User> FindByToken(String token) {

		if (token == null || token.equals(""))
			return Optional.empty();

		Optional<UserAccount> userAccount = userRepo.findByToken(token);
		if (userAccount.isPresent()) {

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

			if (user.getToken() != null) {
				String token = user.getToken().getToken();
				if (token != null || token.equals(""))
					return token;
			}
		}
		return StringUtils.EMPTY;
	}
	
	@Override
	public Token CreateToken() {
		
		Token token = new Token();
		LocalDate date = LocalDate.now();
		token.setToken(UUID.randomUUID().toString());
		token.setRefreshToken(UUID.randomUUID().toString());
		token.setIssueDate(date);
		token.setExpirationDate(date.plusMonths(1));
		return token;
	}

	@Override
	public String createTask(String token, Task task) {

		Optional<UserAccount> userAccount = userRepo.findByToken(token);

		if (userAccount.isPresent()) {
			UserAccount user = userAccount.get();

			// Check if task already exists
			if (user.getTasks().contains(task)) {
				return "Error - task already exists.";
			}

			// Add task
			user.addTasksItem(task);
			userRepo.save(user);

			return "Success - task created.";
		}

		return "Error - user was not found.";
	}

	@Override
	public String deleteTask(String token, String taskName) {

		Optional<UserAccount> userAccount = userRepo.findByToken(token);

		if (userAccount.isPresent()) {
			UserAccount user = userAccount.get();

			// Check if task exists
			Task temp = new Task();
			temp.setName(taskName);

			if (!user.getTasks().contains(temp)) {
				return "Error - task does not exist.";
			}

			// Remove task
			user.getTasks().remove(temp);
			userRepo.save(user);

			return "Success - task deleted.";
		}

		return "Error - user was not found.";
	}

	@Override
	public String updateTask(String token, Task task) {

		Optional<UserAccount> userAccount = userRepo.findByToken(token);

		if (userAccount.isPresent()) {
			UserAccount user = userAccount.get();

			// Check if task exists
			if (!user.getTasks().contains(task)) {
				return "Error - task does not exist.";
			}

			// Update task
			int position = user.getTasks().indexOf(task);
			user.getTasks().set(position, task);

			userRepo.save(user);

			return "Success - task updated.";
		}

		return "Error - user was not found.";
	}

	@Override
	public String toggleCompleted(String token, String taskName) {

		Optional<UserAccount> userAccount = userRepo.findByToken(token);

		if (userAccount.isPresent()) {
			UserAccount user = userAccount.get();

			// Check if task exists
			Task temp = new Task();
			temp.setName(taskName);

			if (!user.getTasks().contains(temp)) {
				return "Error - task does not exist.";
			}

			// Toggle "isCompleted"
			int position = user.getTasks().indexOf(temp);

			user.getTasks().get(position).toggleIsCompleted();
			userRepo.save(user);

			return "Success - task updated.";
		}

		return "Error - user was not found.";
	}

	@Override
	public Movie suggestMovie(String token) {

		Optional<UserAccount> userAccount = userRepo.findByToken(token);

		if (userAccount.isPresent()) {

			UserAccount user = userAccount.get();
			RestTemplate restTemplate = new RestTemplate();

			String targetURL = "http://data.tmsapi.com/v1.1/movies/showings?api_key=pmmqzhbvmsfqpe6fwwhcyt6d";
			String startDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

			// TODO use user zip code instead
			String zipCode = user.getZipCode();

			targetURL += "&zip=" + zipCode + "&startDate=" + startDate;

			ResponseEntity<String> response = restTemplate.getForEntity(targetURL, String.class);
			ObjectMapper objectMapper = new ObjectMapper();

			try {
				Root[] listOfMovies = objectMapper.readValue(response.getBody(), Root[].class);

				if (listOfMovies.length == 0) {
					System.out.println("No movie suggestions found.\n" + targetURL);
					return new Movie();
				}

				Random rand = new Random();
				int randomSuggestion = rand.nextInt(listOfMovies.length);

				Root randomMovie = listOfMovies[randomSuggestion];

				// Parse random movie data into Movie response
				Movie movie = new Movie();
				movie.setTitle(randomMovie.title);
				movie.setReleaseDate(randomMovie.releaseDate);
				movie.setReleaseYear(randomMovie.releaseYear);
				movie.setGenres(randomMovie.genres);
				movie.setDescription(randomMovie.longDescription);

				List<Showtime> showtimes = new ArrayList<Showtime>();

				for (io.swagger.model.moviesapi.Showtime showtime : randomMovie.showtimes) {

					Showtime temp = new Showtime();
					temp.setTheatre(showtime.theatre.name);
					temp.setDate(showtime.dateTime);
					temp.setTicketURI(showtime.ticketURI);

					showtimes.add(temp);
				}

				movie.setShowtimes(showtimes);

				return movie;

			} catch (JsonProcessingException ex) {
				System.out.println("Exception at UserService - suggestMovie" + ex.getMessage());
				return new Movie();
			}
		}

		return new Movie();
	}

}
