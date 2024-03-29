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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T20:17:06.327504-04:00[America/New_York]")
@Api(value = "updateTask", description = "the updateTask API")
public interface UpdateTaskApi {

    @ApiOperation(value = "Updates a task item", nickname = "updateTask", notes = "Updates a task item to the system", authorizations = {
        @Authorization(value = "bearerAuth")    }, tags={ "Task", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Updated task with task name"),
        @ApiResponse(code = 400, message = "Invalid input, object invalid"),
        @ApiResponse(code = 409, message = "An existing item already exists") })
    @RequestMapping(value = "/updateTask",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTask(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody Task body);

}
