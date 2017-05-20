package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sims.dao.EmployeeDao;
import com.sims.models.Employee;

@Repository(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		
		System.out.println("Saving employee Data");
		
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

		System.out.println("Saved employee Data");
	}


}
