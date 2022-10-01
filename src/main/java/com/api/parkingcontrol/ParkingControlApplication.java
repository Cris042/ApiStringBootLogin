package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}

	@GetMapping("/")
	public Object[] getCep() {

		String url = "https://restcountries.com/v2/all";
		RestTemplate restTemplate = new RestTemplate();

		Object[] result = restTemplate.getForObject(url, Object[].class);
		return result;
    }
}
