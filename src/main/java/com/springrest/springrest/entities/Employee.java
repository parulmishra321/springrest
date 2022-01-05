package com.springrest.springrest.entities;

public class Employee {
	
	private int employeeId;
    private String employeeName;
    private int employeeSalary;

	public Employee(int employeeId, String employeeName, int employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

    public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
    
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	public int getEmployeeId(){
        return employeeId;
    }
	
    public int getEmployeeSalary(){
        return employeeSalary;
    }
    
    public String getEmployeeName(){
        return employeeName;
    }

    public String toString(){
        return employeeId+" "+employeeName+" "+employeeSalary;
    }

    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
