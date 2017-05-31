package com.sims.services;

import com.sims.models.Employee;

public interface EmployeeMasterService {
	public void addEmployee(Employee employee);
	public void getEmployeeById(Integer Id);
	public void deeleteEmployeeById(Integer Id);

}
