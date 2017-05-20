package com.sims.pages.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sims.models.Department;
import com.sims.services.DepartmentService;

@Controller
@RequestMapping(value = "/product/*")
public class ProductMasterController {
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;

	@RequestMapping(value = "/showdepartmentmaster", method = RequestMethod.GET)
	public String showDepartmentMasterPage(Model model) {

		System.out.println("Inside Show Department Master Page Method ");
		model.addAttribute("department", new Department());
		return "departmentmaster";
	}
	
	@RequestMapping(value="/savedepartment",method=RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("department") Department department){
		
		System.out.println("Inside Add Department Controller");
		departmentService.addDepartment(department);

		return "departmentmaster";
	}
}
