package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sims.dao.SectionMasterDao;
import com.sims.models.Section;

@Repository(value = "sectionMasterDao")
public class SectionMasterDaoImpl implements SectionMasterDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addSection(Section section) {
		
		System.out.println("Saving Section Data");
		
		sessionFactory.getCurrentSession().saveOrUpdate(section);

		System.out.println("Saved Section Data");
	}


}
