package com.sims.pages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/account/*")
public class AccountPageController {

	@RequestMapping(value="/showaccountmaster",method=RequestMethod.GET)
	public String showAccountMasterPage(){
	
		return "accountmaster";
	}
	
}
