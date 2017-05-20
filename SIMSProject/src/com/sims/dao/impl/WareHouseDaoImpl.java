package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sims.dao.WareHouseDao;
import com.sims.models.WareHouse;

@Repository(value = "wareHouseMasterDao")
public class WareHouseDaoImpl implements WareHouseDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addWareHouse(WareHouse wareHouse) {
		
		System.out.println("Saving wareHouse Data");
		
		sessionFactory.getCurrentSession().saveOrUpdate(wareHouse);

		System.out.println("Saved wareHouse Data");
	}


}
