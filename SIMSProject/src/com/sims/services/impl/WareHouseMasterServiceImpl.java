package com.sims.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sims.dao.WareHouseDao;
import com.sims.models.WareHouse;
import com.sims.services.WareHouseMasterService;

@Service(value="warehouseMasterService")
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class WareHouseMasterServiceImpl implements WareHouseMasterService {
	
	 @Resource(name="wareHouseMasterDao")
	 private WareHouseDao wareHouseMasterDao;
	   

	@Override
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addWareHouse(WareHouse wareHouse) {
		wareHouseMasterDao.addWareHouse(wareHouse);		
	}

}
