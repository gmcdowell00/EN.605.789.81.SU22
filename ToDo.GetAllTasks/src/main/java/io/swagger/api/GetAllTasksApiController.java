package io.swagger.api;

import io.swagger.model.Task;
import io.swagger.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T20:43:32.443523400-04:00[America/New_York]")
@Controller
public class GetAllTasksApiController implements GetAllTasksApi {

    private static final Logger log = LoggerFactory.getLogger(GetAllTasksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Qualifier(value="userService")
    private final UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public GetAllTasksApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userService = userService;
    }

    public ResponseEntity<List<Task>> searchInventory(@NotNull @ApiParam(value = "pass an optional search string for looking up inventory", required = true) @Valid @RequestParam(value = "userName", required = true) String userName) {
        String accept = request.getHeader("Accept");
        String authorizationHeaderValue = request.getHeader("Authorization");
        if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
        	String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
        	List<Task> task = this.userService.findUserTaskByToken(token);
        	return ResponseEntity.ok(task); 
        }
        /*
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Task>>(objectMapper.readValue("[ {
  "dueDate" : "2000-01-23",
  "name" : "Task",
  "description" : "Category",
  "category" : "Category",
  "isCompleted" : false
}, {
  "dueDate" : "2000-01-23",
  "name" : "Task",
  "description" : "Category",
  "category" : "Category",
  "isCompleted" : false
} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Task>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
*/
        return new ResponseEntity<List<Task>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
