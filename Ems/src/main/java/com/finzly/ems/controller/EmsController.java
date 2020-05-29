package com.finzly.ems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.ems.employeepu.Employee;
import com.finzly.ems.service.EmsService;

@RestController
@RequestMapping("/ems")
public class EmsController {
	protected static final Logger LOGGER = LoggerFactory.getLogger(EmsController.class);

	@Autowired
	private EmsService emsService;

	@PostMapping("/login")
	String login(@RequestParam String username, @RequestParam String password) {

		boolean islogin = emsService.login(username, password);
		LOGGER.debug("Login: islogin: " + islogin);
		if (islogin)
			return "success";
		else
			return "username/password does not match";
	}

	@GetMapping("/listEmployees")
	List<Employee> listEmployees(@RequestParam int numberofdays) {
		LOGGER.debug("listEmployees: numberofdays : " + numberofdays);
		List<Employee> listEmployees = emsService.listEmployees(numberofdays);
		return listEmployees;

	}
}