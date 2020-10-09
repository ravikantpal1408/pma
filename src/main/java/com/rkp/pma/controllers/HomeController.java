package com.rkp.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rkp.pma.dao.IEmployeeRepository;
import com.rkp.pma.dao.IProjectRepository;
import com.rkp.pma.dto.IChartDto;
import com.rkp.pma.dto.IEmployeeProject;
import com.rkp.pma.entities.Project;

@Controller
public class HomeController {

	@Value("${version}")
	private String ver;

	@Autowired
	IProjectRepository projRepo;

	@Autowired
	IEmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

		// Map<String, Object> map = new HashMap<>();
		model.addAttribute("versionNumber", ver);

		List<Project> obj = projRepo.findAll();
		model.addAttribute("projects", obj);

		List<IChartDto> chartObj = projRepo.projectDataForPieChart();

		// Lets convert project data object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartObj);

		model.addAttribute("chartData", jsonString);

		List<IEmployeeProject> empList = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectCount", empList);

		return "home/home";
	}

}
