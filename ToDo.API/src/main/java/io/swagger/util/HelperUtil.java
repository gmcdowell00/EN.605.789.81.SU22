package io.swagger.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * Helper utility class
 * 
 * @authors Glenwood McDowell
 *
 */
@Component
public class HelperUtil {

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
