package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.RegisterUserService;

@Controller
@RequestMapping("")
public class RegisterUserController {

	@Autowired
	private RegisterUserService registerUserService;

	public String RegisterUser(UserForm form) {
		User user = new User();
		user.setId(form.getId());
		user.setName(form.getName());
		user.setAddress(form.getAddress());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setTelephone(form.getTelephone());
		user.setZipcode(form.getZipcode());

		registerUserService.RegisterUser(user);

		return "register_user";

	}

}
