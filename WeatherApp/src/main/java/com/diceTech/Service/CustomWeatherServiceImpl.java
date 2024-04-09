package com.diceTech.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomWeatherServiceImpl implements CustomWeatherServiceInterface {

	@Value("${custom.weather.api.key}")
	private String customWeatherApiKey;
	
	@Value("${spring.security.user.name}")
	private String customWweatherCustomClientId;

	@Value("${spring.security.user.password}")
	private String customWeatherCustomClientSecret;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<String> getCustomForecastSummaryByLocation(String city, String customClientId,
			String customClientSecret) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("customClientId", customClientId);
		headers.set("customClientSecret", customClientSecret);

		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		if (CustomAuthenticationService(customClientId, customClientSecret)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client not authenticated.");
		}

		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + customWeatherApiKey;

		try {
			return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		} catch (RestClientException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error communicating with Custom Weather API: " + e.getMessage());
		}
	}

	public ResponseEntity<String> getCustomHourlyForecastByLocation(String city, String customClientId,
			String customClientSecret) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("customClientId", customClientId);
		headers.set("customClientSecret", customClientSecret);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		if (CustomAuthenticationService(customClientId, customClientSecret)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Client not authenticated.");
		}
		
		String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + customWeatherApiKey;

		try {
			return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		} catch (RestClientException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error communicating with Custom Weather API: " + e.getMessage());
		}
	}
	
	private Boolean CustomAuthenticationService(String customClientId, String customClientSecret) {
		if (customWweatherCustomClientId.equals(customClientId)
				&& customWeatherCustomClientSecret.equals(customClientSecret)) {
			return false;
		} else {
			return true;
		}
	}
	
}
