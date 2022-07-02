package com.example.RestfulDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestfulDemo.Model.Response;
import com.example.RestfulDemo.Service.PlacesAPIService;

@RestController
@RequestMapping(path = "api/v1/places")
public class PlacesAPIController {
	
	private final PlacesAPIService placesAPIService;
	
	@Autowired
	public PlacesAPIController(PlacesAPIService placesAPIService) {
		this.placesAPIService = placesAPIService;
	}
	
	
	@GetMapping("/find")
	public Response getResponse(@RequestParam String lon, @RequestParam String lat) {
		
		if (lon != null && lat != null)
			return this.placesAPIService.GetResponse(lon, lat);
		else 
			return this.placesAPIService.GetResponse("39.3097","-76.751718");
				
	}
	
}
