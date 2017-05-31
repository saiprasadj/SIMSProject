package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sims.dao.EmployeeDao;
import com.sims.genaric.dao.GenaricDAO;
import com.sims.models.Employee;

@Repository(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	private GenaricDAO genaricDao;
	
	@Override
	public void addEmployee(Employee employee) {
		
		System.out.println("Saving employee Data");
		genaricDao.saveOrUpdateEntity(employee);
		//sessionFactory.getCurrentSession().saveOrUpdate(employee);

		System.out.println("Saved employee Data");
	}

	@Override
	public Employee getEmployeeById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}


}
