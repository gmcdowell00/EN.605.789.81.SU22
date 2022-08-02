/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Token;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T18:12:46.646471100-04:00[America/New_York]")
@Api(value = "login", description = "the login API")
public interface LoginApi {

    @ApiOperation(value = "Log into application", nickname = "login", notes = "Return authentication token with successful login ", response = Token.class, tags={ "login", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Login results matching criteria", response = Token.class),
        @ApiResponse(code = 401, message = "Unauthorized") })
    @RequestMapping(value = "/login",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Token> login(@NotNull @ApiParam(value = "UserId parameter", required = true) @Valid @RequestParam(value = "userId", required = true) String userId,@NotNull @ApiParam(value = "Password parameter", required = true) @Valid @RequestParam(value = "password", required = true) String password);

}
