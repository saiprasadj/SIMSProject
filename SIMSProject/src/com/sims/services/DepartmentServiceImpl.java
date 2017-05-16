package com.sims.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sims.daos.DepartmentDao;
import com.sims.models.Department;

@Service(value="departmentService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class DepartmentServiceImpl implements DepartmentService{
	
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDepartment(Department department) {
		
		departmentDao.addDepartment(department);
	}

}
