package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Employee;

@Service
public class EmployeeServiceImplement implements EmployeeService {
	
	List<Employee> EmployeeList;
	
	public EmployeeServiceImplement() {
		
		EmployeeList = new ArrayList<>();
		
		EmployeeList.add(new Employee(101, "Parul Mishra", 50000));
		EmployeeList.add(new Employee(102, "Nikita Mishra", 55000));
		EmployeeList.add(new Employee(103, "Arpita Mishra", 15000));	
	}

	@Override
	public List<Employee> getEmployees() {
		return EmployeeList;
	}

	@Override
	public Employee getEmployee(long employeeId) {
		Employee employee1 = null;
		for(Employee employee:EmployeeList)
		{
			if(employee.getEmployeeId()==employeeId)
			{
				employee1 = employee;
				break;
			}
		}
		return employee1;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		EmployeeList.add(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		EmployeeList.forEach(employee1 ->{
			if(employee1.getEmployeeId()== employee.getEmployeeId()) {
				employee1.setEmployeeName(employee.getEmployeeName());
				employee1.setEmployeeSalary(employee.getEmployeeSalary());
				
			}
		});
		return employee;
	}

	@Override
	public void deleteEmployee(long parseLong) {
		EmployeeList = this.EmployeeList.stream().filter(employee->employee.getEmployeeId()!=parseLong).collect(Collectors.toList());
		
	}

}
