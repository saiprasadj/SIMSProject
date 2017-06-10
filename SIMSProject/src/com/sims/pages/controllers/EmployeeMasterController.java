package com.sims.pages.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/getemployee/{empId}",method=RequestMethod.GET)
	public String getEmployeeById(@RequestParam(value = "empID", required = true) Integer empId){
		System.out.println("Inside get employee by Id ");
		Employee empObj=employeeMasterService.getEmployeeById(empId);

		return "employeemaster";
	}
	
	@RequestMapping(value="/delete/{empId}",method=RequestMethod.GET)
	public void deleteEmployeeById(@RequestParam(value = "empID", required = true) Integer empId){
		System.out.println("Inside get employee by Id ");
		employeeMasterService.deeleteEmployeeById(empId);

	}


}
