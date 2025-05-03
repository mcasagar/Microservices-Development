package com.sagarsoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String getWelcomeMessage() {
		String msg = "Welcome to SagarSoft";
		return msg;
	}
}
