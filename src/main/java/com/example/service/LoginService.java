package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class LoginService {
  
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * ログインをする
	 * @param email
	 * @param passward
	 * @return　ユーザー情報が存在しない場合はnullを返す
	 */
	public User login(String email, String passward) {
		User user = userRepository.findByMailAddressAndPassward(email, passward);
		return user;
	}
}
