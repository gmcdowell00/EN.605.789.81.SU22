package com.example.RestfulDemo.Service;

import com.example.RestfulDemo.Model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;

@Service
public class PlacesAPIService {
	
	// Inject environment object
	@Autowired
	private Environment env;
	private String url = "";
	public Response GetResponse(String lon, String lat) {
		try {
			
			// Build URL
			url = env.getProperty("placesApiBase");
			url += env.getProperty("apiKey");
			url += "&at="+lon+","+lat+"&pretty";
			
			// Instantiate rest template
			RestTemplate restTemplate = new RestTemplate();
			
			// Get Response object
			return restTemplate.getForObject(url, Response.class);
			
		} catch (Exception E) {
			return new Response();
		}
	}
}
