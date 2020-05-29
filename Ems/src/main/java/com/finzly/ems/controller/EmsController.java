package com.finzly.ems.controller;

import java.util.List;

import org.json.JSONObject;
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

	@Autowired
	private EmsService emsService;

	@PostMapping("/login")
	String login(@RequestParam String username, @RequestParam String password) {

		boolean islogin = emsService.login(username, password);
		if (islogin)
			return "success";
		else
			return "username/password does not match";
	}

	@GetMapping("/listEmployees")
	List<Employee> listEmployees(@RequestParam int numberofdays) {
		List<Employee> listEmployees = emsService.listEmployees(numberofdays);
		return listEmployees;

	}
}