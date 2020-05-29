package com.finzly.ems.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.finzly.ems.employeepu.Employee;

@Service
public class EmsServiceImpl implements EmsService {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean login(String username, String password) {
		Query query = em.createQuery("Select u from User u where u.name=:name and u.password=:password");
		query.setParameter("name", username);
		query.setParameter("password", password);
		int resultSize = query.getResultList().size();
		if (resultSize > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> listEmployees(int numberofdays) {
		System.out.println(numberofdays);
		List<Employee> employeesList = new ArrayList<Employee>();
		Query query = em
				.createNativeQuery("SELECT e.* FROM Employee e WHERE e.joiningdate BETWEEN (CURDATE() - INTERVAL "
						+ numberofdays + " DAY) AND CURDATE()");
		System.out.println(query.getResultList());

		List<Object[]> employees = (List<Object[]>) query.getResultList();
		for (int i = 0; i < employees.size(); i++) {
			employeesList.add(new Employee(String.valueOf(employees.get(i)[0]), String.valueOf(employees.get(i)[1]),
					String.valueOf(employees.get(i)[2]), (Integer) employees.get(i)[3], (Date) employees.get(i)[4],
					(Date) employees.get(i)[5]));
		}
		System.out.println(employees.size());

		return employeesList;
//		return null;
	}

}
