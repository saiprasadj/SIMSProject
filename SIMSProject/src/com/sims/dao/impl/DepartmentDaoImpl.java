package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sims.dao.DepartmentDao;
import com.sims.models.Department;

@Repository(value = "departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addDepartment(Department department) {
		
		System.out.println("Saving Department Data");
		
		sessionFactory.getCurrentSession().saveOrUpdate(department);

		System.out.println("Saved Department Data");
	}

}
