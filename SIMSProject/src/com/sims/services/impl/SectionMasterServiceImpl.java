package com.sims.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sims.dao.SectionMasterDao;
import com.sims.models.Section;
import com.sims.services.SectionMasterService;

@Service(value="sectionMasterService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class SectionMasterServiceImpl implements SectionMasterService {
	
	 @Resource(name="sectionMasterDao")
	 private SectionMasterDao sectionMasterDao;   
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSection(Section section) {
		sectionMasterDao.addSection(section);		
	}

}
