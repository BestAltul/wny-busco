package com.wnybusco.depew.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wnybusco.depew.model.BigBus;
import com.wnybusco.depew.model.CP4;
import com.wnybusco.depew.model.DotStatus;
import com.wnybusco.depew.model.DotValue;
import com.wnybusco.depew.model.Fleet;
import com.wnybusco.depew.services.BusService;
import com.wnybusco.depew.services.DashCamServiceCP4;
import com.wnybusco.depew.services.DotService;
import com.wnybusco.depew.services.FleetService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/buses")
public class BusesController {	
	
	private final BusService busService; 
	
	private final FleetService fleetService;
	
	private final DotService dotService;
	
	private DashCamServiceCP4 dashCamServiceCP4;
	
		
	@Autowired
	public BusesController(BusService busService, FleetService fleetService, DashCamServiceCP4 dashCamServiceCP4, DotService dotService) {
		this.busService = busService;
		this.fleetService=fleetService;
		this.dashCamServiceCP4=dashCamServiceCP4;
		this.dotService = dotService;		
	}
	
   
	
	@GetMapping("/index")
//	@GetMapping("/fleet")
	public String index(Model model) {
		
	//	model.addAttribute("bigBuses",busService.findAll());

//		return "index";
		return "index";
	}
	
	@GetMapping("/fleet")	
	public String fleet(Model model) {
		
		model.addAttribute("bigBuses",busService.findAll());

		return "fleet";
	}
	
	
	@GetMapping("/general")
	public String general(Model model) {
		
		model.addAttribute("bigBuses",busService.findAll());

		return "Examples";	
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id,Model model) {
		
		model.addAttribute("bigBus",busService.findOne(id));
		
		model.addAttribute("lastDot",dotService.getLastDotDate());
		
		
		return "show";
	}
	
	@GetMapping("/new")
	public String newBigBus(Model model, @ModelAttribute("bigBus") BigBus bigBus,@ModelAttribute("fleet") Fleet fleet, @ModelAttribute("dashCam") CP4 dashCam) {
		
		model.addAttribute("dashCam",dashCamServiceCP4.findAll());
		model.addAttribute("fleet",fleetService.findAll());
		
		return "new";
	}
	
	@GetMapping("/addDot")
	public String addDot(Model model,@ModelAttribute("dotValue") DotValue dotValue) {
		
		return "addDot";
	}
	
	
	@GetMapping("/upload")
	public String uploadBuses() {
		
		return "upload";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id, @ModelAttribute("fleet") Fleet fleet, @ModelAttribute("dashCam") CP4 dashCam) {
		
		model.addAttribute("dashCameras",dashCamServiceCP4.findAll());
		model.addAttribute("bigBus",busService.findOne(id));
		model.addAttribute("fleet",fleetService.findAll());
		
	
		return "edit";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		busService.delete(id);
		return "redirect:/buses/index";
	}
	
	@PatchMapping("/{id}")
	public String Update(@ModelAttribute("bigBus") BigBus bigBus,@ModelAttribute("fleet") Fleet fleet, @ModelAttribute("dashCam") CP4 dashCam,@PathVariable("id") int id) {
		
		busService.update(id, bigBus,fleet,dashCam);
		
		return "redirect:/buses/index";
	}
	
	@PostMapping
	public String Create(@ModelAttribute("bigBus") @Valid BigBus bigBus, @ModelAttribute("fleet") Fleet fleet, @ModelAttribute("dashCam") CP4 dashCam, BindingResult bindingResult) {

		busService.save(bigBus,fleet,dashCam);
		
		return "redirect:/buses/index";
		
	}
	
	@PostMapping("/upload")
	public String Upload() {
		
	//	private String fileName; 
		
		busService.upload("C:/Users/User/Documents/WNY project/Devices.xls");
			
		return "redirect:/buses/index";
		
	}
	
	@PostMapping("/addDot")
	public String addDot(@ModelAttribute("dotValue") DotValue dotValue, @RequestParam("dotStatus") DotStatus dotStatus) {
		
					
		dotService.addNewDotRecord(dotValue,dotStatus);
			
		return "redirect:/buses/addDot";
		
	}
	

}
