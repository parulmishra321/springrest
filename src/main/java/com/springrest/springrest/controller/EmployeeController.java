package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Employee;
import com.springrest.springrest.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Employee Application!!!";
	}
	
	//get all employees
	@GetMapping("/api/v1/employee")
	public List<Employee> getEmployees(){
		return this.employeeService.getEmployees();
	}
	
	//single employee get
	@GetMapping("api/v1/employee/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId){
		return this.employeeService.getEmployee(Long.parseLong(employeeId));
	}
	
	//create new Employee
	@PostMapping("api/v1/employee/{employeeId}")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.addEmployee(employee);
	}
	
	//Update Employee using PUT request
	@PutMapping("/api/v1/employee")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.updateEmployee(employee);
	}
	
	//Delete Employee
	@DeleteMapping("api/v1/employee/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee (@PathVariable String employeeId){
		try {
			this.employeeService.deleteEmployee(Long.parseLong(employeeId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
