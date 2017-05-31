package com.sims.dao;

import com.sims.models.Employee;

public interface EmployeeDao {	
	public void addEmployee(Employee employee);
	public Employee getEmployeeById(Integer Id);
	public String deleteEmployeeById(Integer Id);

}
