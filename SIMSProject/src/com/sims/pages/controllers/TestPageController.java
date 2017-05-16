package com.sims.pages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*")
public class TestPageController {

	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(){

		System.out.println("Requet To Show Home Page");
		return "homepage";
	}
	
	
	@RequestMapping(value = "/test/getTestPage", method = RequestMethod.GET)
	public String getTestPage() {

		System.out.println("From Test page controller");
		return "testpage";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage(){

		System.out.println("Requet To Show Login Page");
		return "login";
	}
	
}
