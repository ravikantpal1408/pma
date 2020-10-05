package com.rkp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rkp.pma.dao.IEmployeeRepository;
import com.rkp.pma.dao.IProjectRepository;
import com.rkp.pma.entities.Employee;
import com.rkp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository projRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Project> obj = projRepo.findAll();
		model.addAttribute("projects", obj);
		
		List<Employee> empList = empRepo.findAll();
		model.addAttribute("employees", empList);
		
		return "home/home";
	}

}
