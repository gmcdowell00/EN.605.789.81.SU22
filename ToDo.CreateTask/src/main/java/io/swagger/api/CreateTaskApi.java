/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Task;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T19:10:39.596972700-04:00[America/New_York]")
@Api(value = "createTask", description = "the createTask API")
public interface CreateTaskApi {

    @ApiOperation(value = "Adds an task item", nickname = "addTask", notes = "Adds a task item to the system", authorizations = {
        @Authorization(value = "bearerAuth")    }, tags={ "Task", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Newly created task ID"),
        @ApiResponse(code = 400, message = "Invalid input, object invalid"),
        @ApiResponse(code = 409, message = "An existing item already exists") })
    @RequestMapping(value = "/createTask",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addTask(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody Task body);

}
