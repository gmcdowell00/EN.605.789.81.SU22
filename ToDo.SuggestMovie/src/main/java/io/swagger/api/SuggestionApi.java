/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T21:10:13.406609200-04:00[America/New_York]")
@Api(value = "suggestion", description = "the suggestion API")
public interface SuggestionApi {

    @ApiOperation(value = "searches inventory", nickname = "searchInventory", notes = "Retrieve movie (maybe external service) ", response = String.class, authorizations = {
        @Authorization(value = "bearerAuth")    }, tags={ "developers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = String.class),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/suggestion",
        produces = { "text/plain" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> searchInventory();

}
