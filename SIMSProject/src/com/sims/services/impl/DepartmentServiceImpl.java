package com.sims.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sims.dao.DepartmentDao;
import com.sims.models.Department;
import com.sims.services.DepartmentService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class DepartmentServiceImpl implements DepartmentService{
    
	@Autowired	
    private DepartmentDao departmentDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addDepartment(Department department) {
        
        departmentDao.addDepartment(department);
    }

}
