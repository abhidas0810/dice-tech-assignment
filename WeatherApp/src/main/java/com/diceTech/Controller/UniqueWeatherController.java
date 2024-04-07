package com.diceTech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diceTech.Service.CustomWeatherServiceInterface;

@RestController
public class UniqueWeatherController {

	@Autowired
	private CustomWeatherServiceInterface customWeatherService;

	@GetMapping("/custom/forecast/summary")
	public ResponseEntity<String> getCustomForecastSummaryByLocation(@RequestParam String city,
			@RequestHeader("customClientId") String customClientId,
			@RequestHeader("customClientSecret") String customClientSecret) {
		if (customClientId == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client ID missing.");
		} else if (customClientSecret == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client secret key missing.");
		} else {
			return customWeatherService.getCustomForecastSummaryByLocation(city, customClientId,
					customClientSecret);
		}
	}

	@GetMapping("/custom/hourly/forecast")
	public ResponseEntity<String> getCustomHourlyForecastByLocation(@RequestParam String city,
			@RequestHeader("customClientId") String customClientId,
			@RequestHeader("customClientSecret") String customClientSecret) {
		if (customClientId == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client ID missing.");
		} else if (customClientSecret == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client secret key missing.");
		} else {
			return customWeatherService.getCustomHourlyForecastByLocation(city, customClientId, customClientSecret);
		}
	}

}
