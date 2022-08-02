package io.swagger.api;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.model.User;
import io.swagger.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-28T21:22:43.336883600-04:00[America/New_York]")
@Controller
public class SignupApiController implements SignupApi {

    private static final Logger log = LoggerFactory.getLogger(SignupApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Qualifier(value="userService")
    private final UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public SignupApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userService = userService;
    }

    public ResponseEntity<String> createUser(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        
        // Check duplicate
        User temp = this.userService.findByUserId(body.getUserId());
        if (temp != null)
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate User");
        
        // Insert User
        this.userService.insertUser(body);
        
        // Find inserted student
        User user = this.userService.findByUserId(body.getUserId());
        
        // If user was successfuly saved      
        if (user.getObjectId() != null)
        	// return userID
        	return ResponseEntity.ok(body.getUserId()); 
        else 
        	// Else. Throw 400
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
