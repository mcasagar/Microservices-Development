package com.sagarsoft.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="Welcome-Service") //Add service name for which service it is going to act as the feign client.
public interface WelcomeFeignClient {
	
	@GetMapping("/welcome")
	public String getWelcomeMessage(); //Method implimentation will be provided at the run time by the Spring cloud.
}
