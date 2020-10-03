package com.rkp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rkp.pma.dao.IEmployeeRepository;
import com.rkp.pma.entities.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@GetMapping("/new")
	public String createEmployeeFormDisplay(Model model) {
		
		model.addAttribute("employee", new Employee());
		
		return "newEmployee";
	}
	
	
	@PostMapping("/save")
	public String saveEmploye(Employee emp, Model model){
		
		empRepo.save(emp);
		
		return "redirect:/employee/new";
		
	}
	

}
