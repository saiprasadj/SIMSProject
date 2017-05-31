package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sims.dao.DepartmentDao;
import com.sims.genaric.dao.GenaricDAO;
import com.sims.models.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private GenaricDAO genaricDao;

	@Override
	public void addDepartment(Department department) {
		
		System.out.println("Saving Department Data");
		
		genaricDao.saveOrUpdateEntity(department);
		System.out.println("Saved Department Data");
	}

}
