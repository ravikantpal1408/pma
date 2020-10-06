package com.rkp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import com.rkp.pma.dao.IEmployeeRepository;
import com.rkp.pma.dao.IProjectRepository;
import com.rkp.pma.entities.Employee;
import com.rkp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project project =new Project();
		
		List<Employee> employees = empRepo.findAll();
		
		model.addAttribute("project",project);
		model.addAttribute("allEmployee",employees);
		
		return "projects/newProject";
	}
	
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		
		// this should handle saving data to database 
		proRepo.save(project);

		// Iterable<Employee> choosenEmps = empRepo.findAllById(employees);
		
		// for(Employee emp: choosenEmps) {
		// 	emp.setProjects(project);
		// 	empRepo.save(emp);
		// }
		
		return "redirect:/projects/new";
	}
	
	

}
