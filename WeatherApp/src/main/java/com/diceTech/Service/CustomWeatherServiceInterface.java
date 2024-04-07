package com.diceTech.Service;

import org.springframework.http.ResponseEntity;

public interface CustomWeatherServiceInterface {
	
	public ResponseEntity<String> getCustomForecastSummaryByLocation(String city, String customClientId, String customClientSecret);
	
	public ResponseEntity<String> getCustomHourlyForecastByLocation(String city, String customClientId, String customClientSecret);

}

