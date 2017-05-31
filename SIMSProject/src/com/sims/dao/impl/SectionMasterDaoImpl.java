package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sims.dao.SectionMasterDao;
import com.sims.genaric.dao.GenaricDAO;
import com.sims.models.Section;

@Repository(value = "sectionMasterDao")
public class SectionMasterDaoImpl implements SectionMasterDao {
	
	@Autowired
	private GenaricDAO genaricDao;

	@Override
	public void addSection(Section section) {
		
		System.out.println("Saving Section Data");
		genaricDao.saveOrUpdateEntity(section);
	//	sessionFactory.getCurrentSession().saveOrUpdate(section);

		System.out.println("Saved Section Data");
	}


}
