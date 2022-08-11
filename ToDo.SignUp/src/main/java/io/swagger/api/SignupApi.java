/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.User;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-28T21:22:43.336883600-04:00[America/New_York]")
@Api(value = "signup", description = "the signup API")
public interface SignupApi {

    @ApiOperation(value = "Adds a new user to the system", nickname = "createUser", notes = "Adds a new user to the system", tags={ "signup", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Newly created user ID"),
        @ApiResponse(code = 400, message = "Invalid input, Object invalid"),
        @ApiResponse(code = 409, message = "An existing item already exists") })
    @RequestMapping(value = "/signup",
        consumes = { "application/json" },
        produces = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> createUser(@ApiParam(value = "Inventory item to add"  )  @Valid @RequestBody User body);

}
