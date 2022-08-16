package io.swagger.api;

/**
 * API exception
 * 
 * @authors Glenwood McDowell & Yaser Albonni
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T18:12:46.646471100-04:00[America/New_York]")
public class ApiException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
