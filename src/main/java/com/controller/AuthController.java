package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AuthController {
	
	@GetMapping({"/login","/"})
	public String getMethodName() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	
}
