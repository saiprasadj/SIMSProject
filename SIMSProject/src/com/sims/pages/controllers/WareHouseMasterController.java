package com.sims.pages.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sims.models.Department;
import com.sims.models.WareHouse;
import com.sims.services.WareHouseMasterService;

@Controller
@RequestMapping(value = "/warehouse/*")
public class WareHouseMasterController {
	
	@Resource(name="warehouseMasterService")
	private WareHouseMasterService wareHouseMasterService;

	@RequestMapping(value = "/showwarehousemaster", method = RequestMethod.GET)
	public String showWareHouseMasterPage(Model model) {

		System.out.println("Inside Show WareHouse Master Page Method ");
		model.addAttribute("wareHouse", new WareHouse());
		return "warehousemaster";
	}
	
	@RequestMapping(value="/savewarehouse",method=RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("wareHouse") WareHouse wareHouse){
		
		System.out.println("Inside Add wareHuseS Controller");
		wareHouseMasterService.addWareHouse(wareHouse);

		return "warehousemaster";
	}
}
