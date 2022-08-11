package io.swagger.api;

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
@Controller(value="/api")
@RequestMapping(path = "/api/v1/")
public class ToDoApiController implements ToDoApi {

    private static final Logger log = LoggerFactory.getLogger(ToDoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Qualifier(value="userService")
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
    public ResponseEntity<String> login(@NotNull @ApiParam(value = "UserId parameter", required = true) @Valid @RequestParam(value = "userId", required = true) String userId,@NotNull @ApiParam(value = "Password parameter", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
        String accept = request.getHeader("Accept");
      
        String token = userService.Login(userId, password);
		if (StringUtils.isEmpty(token)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token not found");
		}
		return ResponseEntity.ok(token);
        /*
        UserAccount user = this.userService.findByUserIdPass(userId, password);
        
        if (user != null)
        	return ResponseEntity.ok(user.getToken());
        
        return new ResponseEntity<Token>(HttpStatus.NOT_IMPLEMENTED);
        */
    }
    
    /***
     * 
     */
    public ResponseEntity<String> createUser(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody UserAccount body) {
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
    public ResponseEntity<Void> addTask(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody Task body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    /***
     * 
     */
    public ResponseEntity<Void> deleteTask(@NotNull @ApiParam(value = "Pass a task name for deletion", required = true) @Valid @RequestParam(value = "taskName", required = true) String taskName) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    /***
     * 
     */
    public ResponseEntity<List<Task>> getTasks(@NotNull @ApiParam(value = "pass an optional search string for looking up inventory", required = true) @Valid @RequestParam(value = "userName", required = true) String userName) {
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
    public ResponseEntity<Void> updateTask(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody Task body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    /**
     *     
     */
    public ResponseEntity<String> suggestMovie() {
        String accept = request.getHeader("Accept");
        /*
        if (accept != null && accept.contains("application/json")) {
            try {
                //return new ResponseEntity<String>(objectMapper.readValue("""", String.class), HttpStatus.NOT_IMPLEMENTED);
            	String me = "0";
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
*/
        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }
    
	public String getToken(@RequestParam("userId") final String userId, @RequestParam("password") final String password) {

		String token = userService.Login(userId, password);
		if (StringUtils.isEmpty(token)) {
			return "Token not found";
		}
		return token;
	}
}
