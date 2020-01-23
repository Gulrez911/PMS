package com.gul.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Project;
import com.gul.entity.User;
import com.gul.repo.UserRepository;

@Controller
@SessionAttributes("usr")
public class UserController {

	@Autowired
	UserRepository repo;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	@GetMapping("list")
	public ModelAndView list(@RequestParam(name = "page", required = false) Integer page,@RequestParam(name = "size", required = false) Integer size) {
		ModelAndView mav = new ModelAndView("listEmployee");
		if (page == null) {
			page = 0;
		}
		if (size == null) {
			size = 2;
		}
		Pageable pageable = PageRequest.of(page, size);
		Page<User> listUser = repo.findByUserTypeNotContainingIgnoreCaseOrderByUserType("Admin", pageable);

		mav.addObject("listuser", listUser.getContent());
		return mav;
	}

	@PostMapping("/authenticate")
	public ModelAndView authenticate(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		user = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		mav.addObject("usr", user);
		if (user == null) {
			mav.addObject("user", new User());
			mav.addObject("msg", "User Name or Password Invalid");
			mav.setViewName("login");
		} else if (user.getUserType().equalsIgnoreCase("Manager")) {
			mav.addObject("user", user);
			mav.setViewName("managerDashboard");
		} else if (user.getUserType().equalsIgnoreCase("Employee")) {
			mav.addObject("user", user);
			mav.setViewName("employeeDashboard");
		} else {
			mav.addObject("user", user);
			mav.setViewName("adminDashboard");
		}
		return mav;
	}

	@GetMapping("/adduser")
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("register");
		List<String> list = new ArrayList<>();
		list.add("Employee");
		list.add("Manager");
		mav.addObject("usertype", list);
		mav.addObject("user", new User());
		return mav;
	}

	@GetMapping("/addEmployee")
	public ModelAndView addEmployee(@SessionAttribute("usr") User usr) {
		ModelAndView mav = new ModelAndView("register2");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping("/saveEmployee")
	public ModelAndView saveEmployee(@SessionAttribute("usr") User usr, @ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("register2");
		user.setManagerId(usr.getId());
		user.setPassword("1234");
		user.setUserType("Employee");
		repo.save(user);
		mav.addObject("msg", "User Added Successfully");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("register");
		user.setPassword("1234");
		repo.save(user);
		List<String> list = new ArrayList<>();
		list.add("Employee");
		list.add("Manager");
		mav.addObject("usertype", list);
		mav.addObject("msg", "User Added Successfully");
		mav.addObject("user", new User());
		return mav;
	}

	@GetMapping("/newProject")
	public ModelAndView newProject() {
		ModelAndView mav = new ModelAndView("addProject");
		List<User> listUser = repo.findByUserTypeContaining("Manager");
		mav.addObject("userList", listUser);
		mav.addObject("project", new Project());
		return mav;
	}
}
