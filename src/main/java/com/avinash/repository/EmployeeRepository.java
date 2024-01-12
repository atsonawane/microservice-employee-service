package com.avinash.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.avinash.model.Employee;

@Repository
public class EmployeeRepository {

	private List<Employee> employees = new ArrayList<>();
	
	public Employee add(Employee employee) {
		employees.add(employee);
		return employee;
	}
	
	public Employee findbyId(Long id) {
		return employees.stream().filter(e -> e.id().equals(id)).findFirst().get();
	}
	
	public List<Employee> findAll(){
		return employees;
	}
	
	public List<Employee> findByDepartmentId(Long departmentId){
		return employees.stream().filter(e -> e.departmentId().equals(departmentId)).toList();
	}
}
