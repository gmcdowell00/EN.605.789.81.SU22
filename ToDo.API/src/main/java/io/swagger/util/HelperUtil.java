package io.swagger.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import io.swagger.model.Task;
import io.swagger.model.Token;
import io.swagger.model.UserAccount;

/**
 * Helper utility class
 * 
 * @authors Glenwood McDowell
 *
 */
@Component
public class HelperUtil {

	/**
	 * Validate user account object
	 * @param userAccount
	 * @return
	 */
	public String validateUserAccount(UserAccount userAccount) {
		
		if (userAccount.getDateOfBirth() == null )
			return "Error - Date of Birth is not specified";
		if (userAccount.getUserId() == null || userAccount.getUserId() == "") 
			return "Error - User ID is not specified";
		if (userAccount.getPassword() == null || userAccount.getPassword() == "")
			return "Error - Password is not specified";
		if (userAccount.getFirstName() == null || userAccount.getFirstName() == "")
			return "Error - Firstname is not specified";
		if (userAccount.getLastName() == null || userAccount.getLastName() == "")
			return "Error - Lastname is not specified";
		if (userAccount.getEmail() == null || userAccount.getEmail() == "")
			return "Error - Email is not specified";		
		if (userAccount.getStreet() == null || userAccount.getStreet() == "")
			return "Error - Street is not specified";
		if (userAccount.getCity() == null || userAccount.getCity() == "")
			return "Error - City is not specified";
		if (userAccount.getState() == null || userAccount.getState() == "")
			return "Error - State is not specified";
		if (userAccount.getZipCode() == null || userAccount.getZipCode() == "")
			return "Error - Zipcode is not specified";		
		
		
		return null;
	}
	
	/**
	 * Error builder function
	 * 
	 * @param errors
	 * @return
	 */
	public String ErrorBuilder(List<ObjectError> errors) {

		// Instantiate string builder
		StringBuilder sb = new StringBuilder();

		// For each error in errors
		for (ObjectError error : errors) {

			// If error is an instance of FieldError
			if (error instanceof FieldError) {

				// Cast to fieldError
				FieldError fieldError = (FieldError) error;

				// Build error list
				sb.append(fieldError.getField() + ": " + fieldError.getDefaultMessage() + System.lineSeparator());
			}
		}

		// Return message
		return sb.toString();
	}

}
