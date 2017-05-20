package com.sims.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sims.dao.EmployeeDao;
import com.sims.models.Employee;
import com.sims.services.EmployeeMasterService;

@Service(value="employeeMasterService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class EmployeeMasterServiceImpl implements EmployeeMasterService {
	
	 @Resource(name="employeeDao")
	 private EmployeeDao employeeDao;   
	@Override
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee wareHouse) {
		employeeDao.addEmployee(wareHouse);		
	}

}
