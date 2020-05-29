package com.finzly.ems.service;

import java.util.List;

import com.finzly.ems.employeepu.Employee;

public interface EmsService {
	boolean login(String username, String password);

	List<Employee> listEmployees(int numberofdays);
}