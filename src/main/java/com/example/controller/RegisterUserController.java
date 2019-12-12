package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.RegisterUserService;

@Controller
@RequestMapping("")
public class RegisterUserController {

	@ModelAttribute
	public RegisterUserForm setUpForm() {
		return new RegisterUserForm();
	}

	@RequestMapping("/register")
	public String index() {
		return "register_user";
	}

	@Autowired
	private RegisterUserService registerUserService;

	@RequestMapping("/registerUser")
	public String RegisterUser(@Validated RegisterUserForm form, BindingResult result) {
		if (result.hasErrors()) {
			return index();
		}

		User user = new User();
		user.setId(form.getId());
		user.setName(form.getName());
		user.setAddress(form.getAddress());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setTelephone(form.getTelephone());
		user.setZipcode(form.getZipcode());

		registerUserService.RegisterUser(user);

		return "redirect:/toLoginPage";

	}

}
