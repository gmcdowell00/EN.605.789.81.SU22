package io.swagger.api;

import io.swagger.model.Movie;
import io.swagger.model.Task;
import io.swagger.model.UserAccount;
import io.swagger.security.SecurityUtil;
import io.swagger.service.UserService;
import io.swagger.util.HelperUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * API controller
 * 
 * @authors Glenwood McDowell & Yaser Albonni
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T18:12:46.646471100-04:00[America/New_York]")
@Controller(value = "/api")
@RequestMapping(path = "/api/v1/")
public class ToDoApiController implements ToDoApi {

	private static final Logger log = LoggerFactory.getLogger(ToDoApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final SecurityUtil securityUtil;

	private final HelperUtil helperUtil;

	@Value("${authorization}")
	private String authorization;

	@Qualifier(value = "userService")
	private final UserService userService;

	@org.springframework.beans.factory.annotation.Autowired
	public ToDoApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService,
			SecurityUtil securityUtil, HelperUtil helperUtil) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.userService = userService;
		this.securityUtil = securityUtil;
		this.helperUtil = helperUtil;
	}

	/**
	 * (Sign-up) Create user if one does not exist
	 * 
	 * @param body
	 * @return
	 */
	public ResponseEntity<String> createUser(
			@ApiParam(value = "Inventory item to add") @Valid @RequestBody UserAccount body,
			BindingResult bindingResult) {

		// Print
		System.out.println("Request to create User");

		// UserAccount parameter has errors
		if (bindingResult.hasErrors()) {

			// Write to console and return error message
			System.out.println("invalid UserAccount parameter");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(this.helperUtil.ErrorBuilder(bindingResult.getAllErrors()));
		}

		// Print
		System.out.println("Checking for duplicate user");

		// Find user by userId
		UserAccount temp = this.userService.findByUserId(body.getUserId());

		// If temp is not null
		if (temp != null) {

			// Print and return bad request
			System.out.println("Canceling insert. Duplicate user exist");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate User");
		}

		// Print
		System.out.println("User doesn't exist. Creating new account");

		// Find inserted student and retrieve entity
		UserAccount user = this.userService.Save(body);

		// If user was successfully saved return status code
		if (user.getObjectId() != null) {

			// Print
			System.out.println("New account created. Returning userId");
			return ResponseEntity.status(HttpStatus.CREATED).body(user.getUserId());
		}

		// Print and return bad request
		System.out.println("New account could not be created");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	/**
	 * Retrieve user token if credentials are valid.
	 * 
	 * @param userId
	 * @param passowrd
	 * @return
	 */
	public ResponseEntity<String> login(
			@NotNull @ApiParam(value = "UserId parameter", required = true) @Valid @RequestParam(value = "userId", required = true) String userId,
			@NotNull @ApiParam(value = "Password parameter", required = true) @Valid @RequestParam(value = "password", required = true) String password) {

		// If userId or password is null or empty
		if (userId == null || userId == "" || password == null || password == "") {

			// Print line
			System.out.println("Invalid UserAccount parameter");

			// Instantiate string builder
			StringBuilder sb = new StringBuilder();
			sb.append("Error:" + System.lineSeparator());

			// If userId null append it
			if (userId == null || userId == "")
				sb.append("UserId cannot be null or empty" + System.lineSeparator());

			// If password is null append it
			if (password == null || password == "")
				sb.append("Password cannot be null or empty" + System.lineSeparator());

			// Return response
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		// Retrieve token for user with specified credentials
		String token = userService.Login(userId, password);

		// If the token is empty return bad request
		if (StringUtils.isEmpty(token))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error - Token not found");

		// Return Status code 200 and user token
		return ResponseEntity.ok(token);
	}

	/**
	 * Add task to user.
	 * 
	 * @param task
	 * @return
	 */
	/*
	 * public ResponseEntity<String> addTask(@RequestHeader("Authorization") String
	 * authorization,
	 * 
	 * @ApiParam(value = "Inventory item to add") @Valid @RequestBody Task task) {
	 */
	public ResponseEntity<String> addTask(@ApiParam(value = "Inventory item to add") @Valid @RequestBody Task task,
			BindingResult bindingResult) {

		// Print
		System.out.println("Request to addTask");

		// Task parameter has errors
		if (bindingResult.hasErrors()) {

			// Write to console and return error message
			System.out.println("Invalid Task parameter");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(this.helperUtil.ErrorBuilder(bindingResult.getAllErrors()));
		}

		// TODO create utility to extract token from header
		// authorization.substring(7);
		// Print
		System.out.println("Verify user");
		String token = this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// If token isn't valid
		if (token == null || token.equals("")) {
			// Print
			System.out.println("Invalid user");
			return new ResponseEntity<String>("Error - Could not verify user.", HttpStatus.BAD_REQUEST);
		}

		// Print
		System.out.println("Valid user");
		System.out.println("Validate task");

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

		// Print
		System.out.println("Valid tasks");

		// Check "isCompleted" parameter - if null then default to false
		if (task.getIsCompleted() == null) {
			task.setIsCompleted(false);
		}

		// Create task
		System.out.println("Creating task.");
		String result = userService.createTask(token, task);

		// Task created return create
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	/**
	 * Delete a task from a user
	 * 
	 * @param taskName
	 * @return
	 */
	/*
	 * public ResponseEntity<String> deleteTask(@RequestHeader("Authorization")
	 * String authorization,
	 * 
	 * @NotNull @ApiParam(value = "Pass a task name for deletion", required =
	 * true) @Valid @RequestParam(value = "taskName", required = true) String
	 * taskName) {
	 */
	public ResponseEntity<String> deleteTask(
			@NotNull @ApiParam(value = "Pass a task name for deletion", required = true) @Valid @RequestParam(value = "taskName", required = true) String taskName) {

		// TODO create utility to extract token from header
		// String token = authorization.substring(7);
		// String token =
		// this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// Print
		System.out.println("Request to deleteTask");

		// TODO create utility to extract token from header
		// authorization.substring(7);
		// Print
		System.out.println("Verify user");
		String token = this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// If token isn't valid
		if (token == null || token.equals("")) {
			// Print
			System.out.println("Invalid user");
			return new ResponseEntity<String>("Error - Could not verify user.", HttpStatus.BAD_REQUEST);
		}

		// Print
		System.out.println("Valid user");

		// Validate required parameters
		if (taskName == null) {
			return new ResponseEntity<String>("Error - taskName parameter is required.", HttpStatus.BAD_REQUEST);
		}

		// Delete task
		String result = userService.deleteTask(token, taskName);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	/**
	 * Retrieve all tasks for user
	 * 
	 * @param userName
	 * @return
	 */
	public ResponseEntity<List<Task>> getTasks() {
		// Print
		System.out.println("Verify user");
		String token = this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// If token isn't valid
		if (token == null || token.equals("")) {
			// Print
			System.out.println("Invalid user");
			return new ResponseEntity<List<Task>>(HttpStatus.BAD_REQUEST);
		}

		// Print
		System.out.println("Valid user");
		System.out.println("Retrieve task by user token");
		List<Task> task = this.userService.findUserTaskByToken(token);
		return ResponseEntity.ok(task);
	}

	/*
	 * public ResponseEntity<String> updateTask(@RequestHeader("Authorization")
	 * String authorization,
	 * 
	 * @ApiParam(value = "Inventory item to add") @Valid @RequestBody Task task) {
	 */
	public ResponseEntity<String> updateTask(@ApiParam(value = "Inventory item to add") @Valid @RequestBody Task task,
			BindingResult bindingResult) {

		System.out.println("Request to updateTask");

		// Task parameter has errors
		if (bindingResult.hasErrors()) {

			// Write to console and return error message
			System.out.println("Invalid Task parameter");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(this.helperUtil.ErrorBuilder(bindingResult.getAllErrors()));
		}

		// Print
		System.out.println("Verify user");
		String token = this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// If token isn't valid
		if (token == null || token.equals("")) {
			// Print
			System.out.println("Invalid user");
			return new ResponseEntity<String>("Error - Could not verify user.", HttpStatus.BAD_REQUEST);
		}

		// Print
		System.out.println("Valid user");

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

		// Update task
		String result = userService.updateTask(token, task);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	/*
	 * public ResponseEntity<String>
	 * markTaskComplete(@RequestHeader("Authorization") String authorization,
	 * 
	 * @NotNull @ApiParam(value = "Pass a task name for update", required =
	 * true) @Valid @RequestParam(value = "taskName", required = true) String
	 * taskName) {
	 */
	public ResponseEntity<String> markTaskComplete(
			@NotNull @ApiParam(value = "Pass a task name for update", required = true) @Valid @RequestParam(value = "taskName", required = true) String taskName) {

		System.out.println("Request to markTaskComplete");
		String token = this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// If token isn't valid
		if (token == null || token.equals("")) {
			// Print
			System.out.println("Invalid user");
			return new ResponseEntity<String>("Error - Could not verify user.", HttpStatus.BAD_REQUEST);
		}

		// Print
		System.out.println("Valid user");

		// Validate required parameters
		if (taskName == null) {
			return new ResponseEntity<String>("Error - taskName parameter is required.", HttpStatus.BAD_REQUEST);
		}

		// TODO create utility to extract token from header
		// String token = authorization.substring(7);

		// Create task
		String result = userService.toggleCompleted(token, taskName);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	/*
	 * public ResponseEntity<Movie> suggestMovie(@RequestHeader("Authorization")
	 * String authorization) {
	 */
	public ResponseEntity<Movie> suggestMovie() {

		// Print
		System.out.println("Verify user");
		String token = this.securityUtil.ExtractTokenFromHeader(request.getHeader(authorization));

		// If token isn't valid
		if (token == null || token.equals("")) {
			// Print
			System.out.println("Invalid user");
			return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
		}

		// Print
		System.out.println("Valid user");
		System.out.println("Request to suggestMovie");

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
