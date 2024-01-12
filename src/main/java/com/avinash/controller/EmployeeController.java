package com.avinash.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avinash.model.Employee;
import com.avinash.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@PostMapping
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}",employee);
		return employeeRepository.add(employee);
	}
	
	@GetMapping
	public List<Employee> findAll(){
		LOGGER.info("All employees found");
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepository.findbyId(id);
	}
	
	@GetMapping("/department/{id}")
	public List<Employee> findEmpByDeptId(@PathVariable Long id){
		return employeeRepository.findByDepartmentId(id);
	}
}
