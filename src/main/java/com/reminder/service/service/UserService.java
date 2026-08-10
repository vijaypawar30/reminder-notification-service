package com.reminder.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reminder.service.dto.AuthResponse;
import com.reminder.service.dto.LoginRequest;
import com.reminder.service.dto.RegisterRequest;
import com.reminder.service.model.User;
import com.reminder.service.repository.UserRepository;
import com.reminder.service.security.JwtUtil;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//Register
	public AuthResponse register(RegisterRequest request) {
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole("USER");
		userRepository.save(user);
		String token = jwtUtil.generateToken(user.getEmail());
		return new AuthResponse(token);
	}
	
	//Login
	public AuthResponse login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(()-> new RuntimeException("User not found!"));
		if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid Password!");
		}
		String token = jwtUtil.generateToken(user.getEmail());
		return new AuthResponse(token);
	}
}
