package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class RegisterUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncorder;
	
	public void RegisterUser(User user) {
//		user.setPassword(user.getPassword());
		user.setPassword(passwordEncorder.encode(user.getPassword()));
		userRepository.insert(user);
	}

}
