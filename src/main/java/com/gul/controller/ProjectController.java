package com.gul.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Project;
import com.gul.entity.User;
import com.gul.repo.ProjectRepository;

@Controller
public class ProjectController {

	@Autowired
	ProjectRepository projectRepository;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@GetMapping("addProject")
	public ModelAndView addProject(@SessionAttribute("usr") User usr) {
		ModelAndView view = new ModelAndView("addProject");
		view.addObject("project", new Project());
		List<Project> listProject = projectRepository.findAllByManagerId(usr.getId());
		view.addObject("listProject", listProject);
		return view;
	}

	@PostMapping("saveProject")
	public ModelAndView saveProject(@SessionAttribute("usr") User usr, @ModelAttribute("project") Project project) {
		ModelAndView view = new ModelAndView("addProject");
		project.setManagerId(usr.getId());
		projectRepository.save(project);
		List<Project> listProject = projectRepository.findAllByManagerId(usr.getId());
		view.addObject("listProject", listProject);
		return view;
	}
}
