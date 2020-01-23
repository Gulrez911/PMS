package com.gul.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Task;
import com.gul.entity.User;
import com.gul.repo.TaskRepository;
import com.gul.repo.UserRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	UserRepository userRepository;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@GetMapping("addTask")
	public ModelAndView addTask(@RequestParam("projectId") long projectId, @SessionAttribute("usr") User usr) {
		ModelAndView view = new ModelAndView("addTask");
		List<Task> listTask = taskRepository.findAllByProjectIdAndManagerId(projectId, usr.getId());
		Task task = new Task();
		System.out.println(projectId);
		task.setProjectId(projectId);
		view.addObject("task", task);
		view.addObject("listTask", listTask);
		return view;
	}

	@PostMapping("saveTask")
	public ModelAndView saveTask(@SessionAttribute("usr") User usr, @ModelAttribute("task") Task task) {
		ModelAndView view = new ModelAndView("addTask");
		task.setManagerId(usr.getId());
		task.setAction("Not Assigned");
		taskRepository.save(task);
		Task task2 = new Task();
		task2.setProjectId(task.getProjectId());
		view.addObject("task",task2);
		List<Task> listTask = taskRepository.findAllByProjectIdAndManagerId(task.getProjectId(), usr.getId());
		view.addObject("listTask", listTask);
		return view;
	}

	@GetMapping("assignTask")
	public ModelAndView assignTask(@RequestParam("taskId") long taskId, @RequestParam("projectId") long projectId,
			@SessionAttribute("usr") User usr) {
		ModelAndView view = new ModelAndView("assignTask");
		Task task = taskRepository.findByIdAndProjectIdAndManagerId(taskId, projectId, usr.getId());
		List<User> users = userRepository.findByManagerId(usr.getId());
		List<String> listEmp = new ArrayList<String>();
		System.out.println("list:  " + users);
		for (User user : users) {
			listEmp.add(user.getEmail());
		}
		System.out.println("use: " + listEmp);
		view.addObject("empList", listEmp);
		view.addObject("task", task);
		return view;
	}

	@PostMapping("assignSuccess")
	public ModelAndView assignSuccess(@ModelAttribute("task") Task task, @SessionAttribute("usr") User usr) {
		ModelAndView view = new ModelAndView("addTask");
		task.setAction("Assigned");
		task.setManagerId(usr.getId());
		taskRepository.save(task);
		List<Task> listTask = taskRepository.findAllByProjectIdAndManagerId(task.getProjectId(), usr.getId());
		Task task2 = new Task();
		task2.setProjectId(task.getProjectId());
		view.addObject("task", task2);
		view.addObject("listTask", listTask);
		return view;
	}
}