package com.reminder.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reminder.service.dto.AuthResponse;
import com.reminder.service.dto.LoginRequest;
import com.reminder.service.dto.RegisterRequest;
import com.reminder.service.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	//Register
	@PostMapping("/register")
	public AuthResponse register(@RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	
	//Login 
	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		return userService.login(request);
	}
}
