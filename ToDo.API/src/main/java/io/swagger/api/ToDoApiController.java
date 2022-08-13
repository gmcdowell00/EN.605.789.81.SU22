package io.swagger.api;

import io.swagger.model.Movie;
import io.swagger.model.Task;
import io.swagger.model.Token;
import io.swagger.model.UserAccount;
import io.swagger.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T18:12:46.646471100-04:00[America/New_York]")
@Controller(value = "/api")
@RequestMapping(path = "/api/v1/")
public class ToDoApiController implements ToDoApi {

	private static final Logger log = LoggerFactory.getLogger(ToDoApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Qualifier(value = "userService")
	private final UserService userService;

	@org.springframework.beans.factory.annotation.Autowired
	public ToDoApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.userService = userService;
	}

	/***
	 * 
	 */
	public ResponseEntity<String> login(
			@NotNull @ApiParam(value = "UserId parameter", required = true) @Valid @RequestParam(value = "userId", required = true) String userId,
			@NotNull @ApiParam(value = "Password parameter", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		String accept = request.getHeader("Accept");

		String token = userService.Login(userId, password);
		if (StringUtils.isEmpty(token)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token not found");
		}
		return ResponseEntity.ok(token);
		/*
		 * UserAccount user = this.userService.findByUserIdPass(userId, password);
		 * 
		 * if (user != null) return ResponseEntity.ok(user.getToken());
		 * 
		 * return new ResponseEntity<Token>(HttpStatus.NOT_IMPLEMENTED);
		 */
	}

	/***
	 * 
	 */
	public ResponseEntity<String> createUser(
			@ApiParam(value = "Inventory item to add") @Valid @RequestBody UserAccount body) {
		String accept = request.getHeader("Accept");

		// Check duplicate
		UserAccount temp = this.userService.findByUserId(body.getUserId());
		if (temp != null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate User");

		// Insert User
		this.userService.insertUser(body);

		// Find inserted student
		UserAccount user = this.userService.findByUserId(body.getUserId());

		// If user was successfuly saved
		if (user.getObjectId() != null)
			// return userID
			return ResponseEntity.ok(body.getUserId());
		else
			// Else. Throw 400
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	/***
	 *     
	 */
	public ResponseEntity<String> addTask(@RequestHeader("Authorization") String authorization,
			@ApiParam(value = "Inventory item to add") @Valid @RequestBody Task task) {

		System.out.println("Request to addTask");

		// Validate required parameters
		if (task.getName() == null) {
			return new ResponseEntity<String>("Error - Name parameter is required.", HttpStatus.BAD_REQUEST);
		}
		if (task.getDueDate() == null) {
			return new ResponseEntity<String>("Error - Due date parameter is required.", HttpStatus.BAD_REQUEST);
		}

		// Validate parameters format
		if (task.getName().length() < 3 || task.getName().length() > 100) {
			return new ResponseEntity<String>("Error - Name length should be between 3 and 100 characters.",
					HttpStatus.BAD_REQUEST);
		}
		if (task.getCategory() != null && (task.getCategory().length() < 3 || task.getCategory().length() > 100)) {
			return new ResponseEntity<String>("Error - Category length should be between 3 and 100 characters.",
					HttpStatus.BAD_REQUEST);
		}
		if (task.getDescription() != null && task.getDescription().length() > 2000) {
			return new ResponseEntity<String>("Error - Description cannot be more than 2000 characters.",
					HttpStatus.BAD_REQUEST);
		}

		// TODO create utility to extract token from header
		String token = authorization.substring(7);

		// Check "isCompleted" parameter - if null then default to false
		if (task.getIsCompleted() == null) {
			task.setIsCompleted(false);
		}

		// Create task
		String result = userService.createTask(token, task);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	/***
	 * 
	 */
	public ResponseEntity<String> deleteTask(@RequestHeader("Authorization") String authorization,
			@NotNull @ApiParam(value = "Pass a task name for deletion", required = true) @Valid @RequestParam(value = "taskName", required = true) String taskName) {

		System.out.println("Request to deleteTask");

		// Validate required parameters
		if (taskName == null) {
			return new ResponseEntity<String>("Error - taskName parameter is required.", HttpStatus.BAD_REQUEST);
		}

		// TODO create utility to extract token from header
		String token = authorization.substring(7);

		// Delete task
		String result = userService.deleteTask(token, taskName);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	/***
	 * 
	 */
	public ResponseEntity<List<Task>> getTasks(
			@NotNull @ApiParam(value = "pass an optional search string for looking up inventory", required = true) @Valid @RequestParam(value = "userName", required = true) String userName) {
		String accept = request.getHeader("Accept");
		String authorizationHeaderValue = request.getHeader("Authorization");
		if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
			String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
			List<Task> task = this.userService.findUserTaskByToken(token);
			return ResponseEntity.ok(task);
		}

		return new ResponseEntity<List<Task>>(HttpStatus.NOT_IMPLEMENTED);
	}

	/***
	 * 
	 */
	public ResponseEntity<String> updateTask(@RequestHeader("Authorization") String authorization,
			@ApiParam(value = "Inventory item to add") @Valid @RequestBody Task task) {

		System.out.println("Request to updateTask");

		// Validate required parameters
		if (task.getName() == null) {
			return new ResponseEntity<String>("Error - Name parameter is required.", HttpStatus.BAD_REQUEST);
		}
		if (task.getDueDate() == null) {
			return new ResponseEntity<String>("Error - Due date parameter is required.", HttpStatus.BAD_REQUEST);
		}

		// Validate parameters format
		if (task.getName().length() < 3 || task.getName().length() > 100) {
			return new ResponseEntity<String>("Error - Name length should be between 3 and 100 characters.",
					HttpStatus.BAD_REQUEST);
		}
		if (task.getCategory() != null && (task.getCategory().length() < 3 || task.getCategory().length() > 100)) {
			return new ResponseEntity<String>("Error - Category length should be between 3 and 100 characters.",
					HttpStatus.BAD_REQUEST);
		}
		if (task.getDescription() != null && task.getDescription().length() > 2000) {
			return new ResponseEntity<String>("Error - Description cannot be more than 2000 characters.",
					HttpStatus.BAD_REQUEST);
		}

		// TODO create utility to extract token from header
		String token = authorization.substring(7);

		// Update task
		String result = userService.updateTask(token, task);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	/**
	 *     
	 */
	public ResponseEntity<String> markTaskComplete(@RequestHeader("Authorization") String authorization,
			@NotNull @ApiParam(value = "Pass a task name for update", required = true) @Valid @RequestParam(value = "taskName", required = true) String taskName) {

		System.out.println("Request to markTaskComplete");

		// Validate required parameters
		if (taskName == null) {
			return new ResponseEntity<String>("Error - taskName parameter is required.", HttpStatus.BAD_REQUEST);
		}

		// TODO create utility to extract token from header
		String token = authorization.substring(7);

		// Create task
		String result = userService.toggleCompleted(token, taskName);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	/**
	 *     
	 */
	public ResponseEntity<Movie> suggestMovie(@RequestHeader("Authorization") String authorization) {

		System.out.println("Request to suggestMovie");

		// TODO create utility to extract token from header
		String token = authorization.substring(7);

		return new ResponseEntity<Movie>(userService.suggestMovie(token), HttpStatus.OK);
	}

	public String getToken(@RequestParam("userId") final String userId,
			@RequestParam("password") final String password) {

		String token = userService.Login(userId, password);
		if (StringUtils.isEmpty(token)) {
			return "Token not found";
		}
		return token;
	}
}
