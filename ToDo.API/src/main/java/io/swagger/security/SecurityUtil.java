package io.swagger.security;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

	public String ExtractTokenFromHeader(String authorizationHeaderValue) {
		if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
			return authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		}
		return null;
	}
}
