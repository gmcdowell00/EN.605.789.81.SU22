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
	
	public Response GetHereResponse(String lon, String lat) {
		try {
						
			// Instantiate rest template
			RestTemplate restTemplate = new RestTemplate();
			
			// Get Response object
			return restTemplate.getForObject(this.BuildUrl(lon, lat, null), Response.class);
			
		} catch (Exception E) {
			return new Response();
		}
	}
	
	public Response GetSearchResponse(String lon, String lat, String search) {
		try {
			
			// Instantiate rest template
			RestTemplate restTemplate = new RestTemplate();
			
			// Get Response object
			return restTemplate.getForObject(this.BuildUrl(lon, lat, search), Response.class);
			
		} catch (Exception E) {
			return new Response();
		}
	}
	
	private String BuildUrl(String lon, String lat, String search) {
		
		String url = "";
		if (search == null) {
			url += env.getProperty("here");
			url += env.getProperty("apiKey");
			url += "&at="+lon+","+lat+"&pretty";
		}
		else {
			// Build URL
			url = env.getProperty("search");
			url += env.getProperty("apiKey");
			url += "&at="+lon+","+lat;
			url += "&q="+search+"&pretty";
		}
		
		return url;
	}
}
