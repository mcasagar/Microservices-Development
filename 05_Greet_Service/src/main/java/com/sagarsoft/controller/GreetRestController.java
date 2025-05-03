package com.sagarsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagarsoft.client.WelcomeFeignClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeFeignClient welcomeClient;
	
	@GetMapping("/greet")
	public String getGreetMessage(String message) {
		
		String welcomeMessage = welcomeClient.getWelcomeMessage();
		
		String msg = "Good Morning...!! ";
		
		return msg + welcomeMessage;
		
	}
}
