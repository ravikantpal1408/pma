package com.rkp.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rkp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project project =new Project();
		model.addAttribute("project",project);
		
		return "newProject";
	}
	
	

}
