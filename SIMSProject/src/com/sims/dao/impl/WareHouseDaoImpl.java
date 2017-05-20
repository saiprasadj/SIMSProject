package com.sims.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sims.dao.ProductDao;
import com.sims.models.Product;

@Repository(value = "ProductDao")
public class ProductDaoImpl implements ProductDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		
		System.out.println("Saving product Data");
		
		sessionFactory.getCurrentSession().saveOrUpdate(product);

		System.out.println("Saved product Data");
	}


}
