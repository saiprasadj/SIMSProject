package com.sims.pages.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sims.models.Employee;
import com.sims.models.Section;
import com.sims.services.SectionMasterService;

@Controller
@RequestMapping(value = "/section/*")
public class SectionMasterController {
	
	@Resource(name="sectionMasterService")
	private SectionMasterService sectionMasterService;

	@RequestMapping(value = "/showsectionmaster", method = RequestMethod.GET)
	public String showEmployeeMasterPage(Model model) {

		System.out.println("Inside Show Section Master Page Method ");
		model.addAttribute("section", new Section());
		return "sectionmaster";
	}
	
	@RequestMapping(value="/savesection",method=RequestMethod.POST)
	public String addSection(@ModelAttribute("section") Section section){
		System.out.println("Inside Add section Controller");
		sectionMasterService.addSection(section);

		return "sectionmaster";
	}
}
