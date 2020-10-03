package com.rkp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rkp.pma.dao.IProjectRepository;
import com.rkp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project project =new Project();
		model.addAttribute("project",project);
		
		return "newProject";
	}
	
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		// this should handle saving data to database 
		
		proRepo.save(project);
		
		return "redirect:/projects/new";
	}
	
	

}
