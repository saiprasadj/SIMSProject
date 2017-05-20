package com.sims.pages.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sims.models.Employee;
import com.sims.models.WareHouse;
import com.sims.services.EmployeeMasterService;

@Controller
@RequestMapping(value = "/employee/*")
public class EmployeeMasterController {
	
	@Resource(name="employeeMasterService")
	private EmployeeMasterService employeeMasterService;

	@RequestMapping(value = "/showemployeemaster", method = RequestMethod.GET)
	public String showEmployeeMasterPage(Model model) {

		System.out.println("Inside Show Employee Master Page Method ");
		model.addAttribute("employee", new Employee());
		return "employeemaster";
	}
	
	@RequestMapping(value="/saveemployee",method=RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") Employee employee){
		System.out.println("Inside Add employee Controller");
		employeeMasterService.addEmployee(employee);

		return "employeemaster";
	}
}
