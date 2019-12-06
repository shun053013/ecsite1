package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ToLoginPageController {
	
	@RequestMapping("/toLogin")
	public String showLoginPage() {
		return "login";
	}

}
