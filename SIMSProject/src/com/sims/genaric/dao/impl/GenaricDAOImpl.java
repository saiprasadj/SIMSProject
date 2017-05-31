package com.sims.genaric.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.sims.genaric.dao.GenaricDAO;
import com.sims.utils.SIMSConstants;

@Transactional(propagation= Propagation.REQUIRED)
public class GenaricDAOImpl implements GenaricDAO {

	private static final Logger logger = LoggerFactory.getLogger(GenaricDAOImpl.class);

	SessionFactory sessionFactory;

	HibernateTemplate adminUIHibernateTemplate;
	
	HibernateTransactionManager transactionManager;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getAdminUIHibernateTemplate() {
		return adminUIHibernateTemplate;
	}

	public void setAdminUIHibernateTemplate(
			HibernateTemplate adminUIHibernateTemplate) {
		this.adminUIHibernateTemplate = adminUIHibernateTemplate;
	}
	
	/**
	 * @return the transactionManager
	 */
	public HibernateTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * @param transactionManager the transactionManager to set
	 */
	public void setTransactionManager(HibernateTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 * It will save or update the entity
	 *
	 * @param  entity to save or update to database
	 * @return the saved or updated entity
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Object saveOrUpdateEntity(final Object entity) {

		return getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				return session.merge(entity);

			}
		});
	}

	@Override
	public Object saveOrUpdateEntityUsingFilter(final Object entity, final String filterName, final String filterColumnName, final String filterString) {

		return getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Filter filter = session.enableFilter(filterName);
				filter.setParameter(filterColumnName, filterString);
				return session.merge(entity);

			}
		});
	}
	
	@Override
	public void saveOrUpdateEntityList(final List<?> entities){

		getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Transaction transaction = session.getTransaction();
				transaction.begin();
				try{

					for(Object entity : entities){
						session.merge(entity);
					}

					transaction.commit();

				}catch(Exception e){
					transaction.rollback();
					throw e;
				}
				return null;
			}
		});

	}

	/**
	 *
	 * @param entity to save or update to database. In case of exception rollback is executed.
	 * @return the saved or updated entity if successful else null is returned.
     */
	@Override
	public Object saveOrUpdateEntityByTransaction(final Object entity){

		return getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Transaction transaction = session.getTransaction();
				transaction.begin();
				Object obj;
				try{

					obj = session.merge(entity);
					transaction.commit();

				}catch(Exception e){
					transaction.rollback();
					throw e;
				}

				return obj;

			}
		});

	}

	/**
	 * It will delete entity from database
	 *
	 * @param  entity to delete from database
	 * @param  id , primary key of entity 
	 * @return void
	 */
	@Override
	public void deleteEntityById(final Class entity, final Integer id) {

		getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				 session.delete(session.get(entity, id));
				 
				return null;
			}
		});
	}
	
	/**
	 * It find entity from database
	 *
	 * @param  entity to find from database
	 * @param  id , primary key of entity 
	 * @return entity
	 */
	@Override
	public Object findEntityById(final Class entity, final Integer id) {

		 return getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				 
				return session.get(entity, id);
				
			}
		});
	
	}

	@Override
	public List executeNativeQuery( final String nativeQuery, final Class entity ) {
		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createSQLQuery(nativeQuery).addEntity(entity);
				Criteria criteria = session.createCriteria(entity);
				criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				return query.list();

			}
		});
	}
	
	
	@Override
	public List executeNativeQueryByPagination( final String nativeQuery, final Class entity , final Map<String, Serializable> inputMap ) {
		
		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createSQLQuery(nativeQuery).addEntity(entity);
				
				Criteria criteria = session.createCriteria(entity);
				
				criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
				query.setFirstResult(Integer.parseInt(inputMap.get(SIMSConstants.START_INDEX).toString()) - 1);

				query.setMaxResults(Integer.parseInt(inputMap.get(SIMSConstants.PAGE_SIZE).toString()));
				
				return query.list();

			}
		});
	}
	
	
	
	@Override
	public List executeSelectByNamedQuery( final String hql, final  Map<String, Serializable> inputMap ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createQuery(hql);

				for (Map.Entry<String, Serializable> entry : inputMap.entrySet())

					query.setParameter(entry.getKey(), entry.getValue());

				return query.list();

			}
		});
	}
	
	
	@Override
	public List executeSelectByNamedQuery( final String hql ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createQuery(hql);

				return query.list();

			}
		});
	}
	
	@Override
	public List executeSelectByCriteria( final Class entity, final String joinEntityName , final  Map<String, Serializable> inputMap ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Criteria criteria = session.createCriteria(entity);
				
				criteria.setFetchMode(joinEntityName, FetchMode.JOIN);
				
				for (Map.Entry<String, Serializable> entry : inputMap.entrySet())

					criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
				
				return criteria.list(); 
				
			}
		});
	}
	

	@Override
	public List executeSelectByFilter( final Class entity, final String filterName, final String filterColumnName, final String filterString, final String columnName, final String input ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Filter filter = session.enableFilter(filterName);
				filter.setParameter(filterColumnName, filterString);

				Criteria criteria = session.createCriteria(entity).add(Restrictions.eq(columnName, input));
				//return query.list();
				return criteria.list();
			}
		});
	}
	

	/**
	 * It will return list by executing named query with input 
	 *
	 * @param  namedQuery 
	 * @param  entity 
	 * @param input 
	 * @return list
	 */
	@Override
	public List executeNamedQuery( final String namedQuery , final Class entity, final String input) {

		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createSQLQuery(namedQuery).addEntity(entity);
				
				query.setParameter(0, input);
				
				return query.list();
				
			}
		});
	
	}
	
	/**
	 * It will return list by taking hibernate entity
	 *
	 * @param  entity 
	 * @return list
	 */
	@Override
	public List executeNamedQuery(final Class entity) {

		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Criteria criteria = session.createCriteria(entity);
				
				criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
				return criteria.list();
				
			}
		});
	
	}
	
	/**
	 * It will return list by executing native query with input
	 *
	 * @param  nativeQuery 
	 * @param  entity 
	 * @param input
	 * @return list
	 */
	@Override
	public List executeNativeQuery(final String nativeQuery , final Class entity, final String input) {
		
		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createSQLQuery(nativeQuery).addEntity(entity);
				
				query.setParameter(0, input);
				
			    return query.list();
				
			}
		});
	
	}
	
	
	@Override
	public List executeNamedQueryByCriteria( final Class entity , final Map<String, Serializable> inputMap) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Criteria criteria = session.createCriteria(entity);
				
				criteria.addOrder(Order.desc(inputMap.get("parentEntityId").toString()));

				criteria.add(Restrictions.isNull(inputMap.get("childEntityId").toString()));

				criteria.setFirstResult(Integer.parseInt(inputMap.get("startIndex").toString()) - 1);

				criteria.setMaxResults(Integer.parseInt(inputMap.get("pageSize").toString()));

				return criteria.list();

			}
		});

	}
	
	
	@Override
	public List executeNativeQuery(final String nativeQuery) {
		
		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createSQLQuery(nativeQuery);
				
			    return query.list();
				
			}
		});
	
	}
	
	
	/**
	 * It will return list by executing native query with columnName and inputValues
	 *
	 * @param  nativeQuery 
	 * @param  columnName 
	 * @param  entity 
	 * @param inputValues 
	 * @return list
	 */
	@Override
	public List executeListByNativeQuery(final String nativeQuery , final String columnName , final Class entity,final List<String> inputValues) {
		
		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createSQLQuery(nativeQuery).addEntity(entity); 
				
				query.setParameterList(columnName, inputValues);
				
				return  query.list();
				
			}
		});
	}
	
	/**
	 * It will execute Update Or Delete By NativeQuery 
	 *
	 * @param  nativeQuery 
	 * @param  inputName 
	 * @param inputValues 
	 * @return The number of entities updated or deleted 
	 */
	@Override
	public int executeUpdateOrDeleteByNativeQuery(final String nativeQuery , final String inputName , final List<String> inputValues) {
		
		 return (int) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createSQLQuery(nativeQuery); 
				
				query.setParameterList(inputName, inputValues);
				
				return query.executeUpdate(); 
				
			}
		});
	}
	
	
	@Override
	public int executeUpdateOrDeleteByNativeQuery(final String nativeQuery , final Map<String,Serializable> inputMap) {

		return (int) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createSQLQuery(nativeQuery);

				for (Map.Entry<String, Serializable> entry : inputMap.entrySet())

					query.setParameter(entry.getKey(), entry.getValue());

				return query.executeUpdate(); 

			}
		});
	}
	
	
	
	@Override
	public int executeUpdateOrDeleteByNamedQuery(final String hql , final Map<String,Serializable> inputMap) {

		return (int) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createQuery(hql);

				for (Map.Entry<String, Serializable> entry : inputMap.entrySet())

					query.setParameter(entry.getKey(), entry.getValue());

				return query.executeUpdate(); 

			}
		});
	}
	
	

	/**
	 * It will execute the Criteria With Condition and returns single record from the database.
	 *
	 * @param  entity 
	 * @param  conditionColumnName 
	 * @param inputValue 
	 * @return  The instance that matches the query 
	 */
	@Override
	public Object executeCriteriaWithCondition(final Class entity, final String conditionColumnName, final Object inputValue) {

		 return (Object) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Criteria criteria = session.createCriteria(entity);
				
				criteria.add(Restrictions.eq(conditionColumnName, inputValue));
				
				criteria.setMaxResults(1);
				
				return criteria.uniqueResult();
				
			}
		});
	
	}
	/**
	 * It will execute the Criteria With Condition and returns the list of records from the database. 
	 *
	 * @param  entity 
	 * @param  conditionColumnName 
	 * @param inputValue 
	 * @return  The instance that matches the query 
	 */
	@Override
	public List executeCriteriaListWithCondition(final Class entity, final String conditionColumnName, final Object inputValue) {

		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			 @Override
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(entity);
				criteria.add(Restrictions.eq(conditionColumnName, inputValue));
				return criteria.list();
				
			}
		});
	
	}
	
	@Override
	public List executeCriteria(final Class entity, final Map<String,Serializable> columnValues) {

		 return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				 
				Criteria criteria = session.createCriteria(entity);
				
				for (Map.Entry<String, Serializable> entry : columnValues.entrySet())
					
				criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
				
				return criteria.list();
				
			}
		});
	
	}

	/**
	 * It will execute the Criteria With Condition and returns the list of records from the database.
	 *
	 * @param  entity
	 * @param  conditionColumnName
	 * @param inputValue
	 * @return  The instance that matches the query
	 */
	@Override
	public List executeCriteriaListWithMultipleConditionInput(final Class entity, final String conditionColumnName, final List inputValue) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(entity);
				criteria.add(Restrictions.in(conditionColumnName, inputValue));
				return criteria.list();

			}
		});

	}

	@Override
	public Object findEntityById(final Class entity, final String id) {


		 return getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				 
				return session.get(entity, id);
				
			}
		});
	}

	@Override
	public void deleteEntityById(final Class entity, final String id) {

		getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				 session.delete(session.get(entity, id));
				 
				return null;
			}
		});		
	}

	@Override
	public void deleteEntity(final Object entity) {
		getAdminUIHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				session.delete(entity);
				return null;
			}
		});
	}
	
	@Override
	public Object loadEntity(final Class theClass, final Serializable id) {


		return getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				return session.load( theClass,  id);

			}
		});
	
	}

	/**
	 * It will execute the Criteria With Condition and returns the list of records from the database.
	 *
	 * @param entity
	 * @param inputMap
     * @return
     */
	@Override
	public List executeFilterCriteriaByPagination(final Class entity,  final Map<String, Serializable> inputMap ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Criteria criteria = session.createCriteria(entity);
				
				if ( inputMap.get(SIMSConstants.SORT_TYPE) != null && inputMap.get(SIMSConstants.SORT_TYPE).toString().equals(SIMSConstants.ASC)) 

					criteria.addOrder(Order.asc(inputMap.get(SIMSConstants.PARENT_ENTITY_ID).toString()));

				else if ( inputMap.get(SIMSConstants.SORT_TYPE) != null && inputMap.get(SIMSConstants.SORT_TYPE).toString().equals(SIMSConstants.DESC))

					criteria.addOrder(Order.desc(inputMap.get(SIMSConstants.PARENT_ENTITY_ID).toString()));
				
				criteria.setFirstResult(Integer.parseInt(inputMap.get(SIMSConstants.START_INDEX).toString()) - 1);

				criteria.setMaxResults(Integer.parseInt(inputMap.get(SIMSConstants.PAGE_SIZE).toString()));
				
				criteria.add(Restrictions.sqlRestriction( "UPPER(this_."+inputMap.get(SIMSConstants.SEARCH_COLUMN).toString() +") LIKE UPPER('%"+inputMap.get(SIMSConstants.SEARCH_STRING).toString()+"%') "));
				
				return criteria.list();

			}
		});

	}
	
	@Override
	public List executeFilterCriteria(final Class entity,  final Map<String, Serializable> inputMap ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Criteria criteria = session.createCriteria(entity);
				
				criteria.addOrder(Order.desc(inputMap.get(SIMSConstants.PARENT_ENTITY_ID).toString()));
				
				criteria.add(Restrictions.sqlRestriction( "UPPER(this_."+inputMap.get(SIMSConstants.SEARCH_COLUMN).toString() +") LIKE UPPER('%"+inputMap.get(SIMSConstants.SEARCH_STRING).toString()+"%') "));
				
				return criteria.list();

			}
		});

	}
	


	@Override
	public List executeNamedQueryByPagination( final Class entity , final Map<String, Serializable> inputMap) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Criteria criteria = session.createCriteria(entity);
				
				criteria.addOrder(Order.desc(inputMap.get(SIMSConstants.PARENT_ENTITY_ID).toString()));

				criteria.setFirstResult(Integer.parseInt(inputMap.get(SIMSConstants.START_INDEX).toString()) - 1);

				criteria.setMaxResults(Integer.parseInt(inputMap.get(SIMSConstants.PAGE_SIZE).toString()));

				return criteria.list();

			}
		});

	}
	
	
	@Override
	public List executeCriteriaWithPagingAndSorting(final Class entity , final Map<String, Serializable> inputMap) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Criteria criteria = session.createCriteria(entity);

				if ( inputMap.get(SIMSConstants.SORT_TYPE) != null && inputMap.get(SIMSConstants.SORT_TYPE).toString().equals(SIMSConstants.ASC)) 

					criteria.addOrder(Order.asc(inputMap.get(SIMSConstants.PARENT_ENTITY_ID).toString()));

				else if ( inputMap.get(SIMSConstants.SORT_TYPE) != null && inputMap.get(SIMSConstants.SORT_TYPE).toString().equals(SIMSConstants.DESC))

					criteria.addOrder(Order.desc(inputMap.get(SIMSConstants.PARENT_ENTITY_ID).toString()));

				criteria.setFirstResult(Integer.parseInt(inputMap.get(SIMSConstants.START_INDEX).toString()) - 1);

				criteria.setMaxResults(Integer.parseInt(inputMap.get(SIMSConstants.PAGE_SIZE).toString()));

				return criteria.list();

			}
		});

	}


	@Override
	public Number getRowCountByEntity( final Class entity) {

		return (Number) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				return (Number) session.createCriteria(entity).setProjection(Projections.rowCount()).uniqueResult();

			}
		});

	}

	@Override
	public Number getRowCountByEntity( final String hql ) {

		return (Number) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				return ((Number) session.createQuery(hql).list().size());
			}
		});
	}

	@Override
	public List executeNamedQueryByPagination(final String hql , final  Map<String, Serializable> inputMap ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createQuery(hql);
				
				query.setFirstResult(Integer.parseInt(inputMap.get(SIMSConstants.START_INDEX).toString()) - 1);

				query.setMaxResults(Integer.parseInt(inputMap.get(SIMSConstants.PAGE_SIZE).toString()));

			    return query.list();

			}
		});

	}
	
	@Override
	public List executeNamedQueryByPagination(final String hql  ) {

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createQuery(hql);
				
			    return query.list();

			}
		});

	}


	public List executeNamedQueryByPaginationReturnDistinct(){
		return null;
	}

	@Override
	public List executeMultipleOperation(final Map<String, Serializable> stringObjectMap){

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {

				Transaction transaction = session.getTransaction();
				transaction.begin();
				List respList = new ArrayList();
				try{
					String operationName = String.valueOf(stringObjectMap.get("operationName"));
					if(operationName != null && (operationName.equalsIgnoreCase("insert") || operationName.equalsIgnoreCase("update"))){
						List list = (List) stringObjectMap.get("operationList");

						for(Object obj : list){
							logger.debug("b4 persisting :: "+new Gson().toJson(obj));
							Object o = session.merge(obj);
							logger.debug("after persting :: "+new Gson().toJson(o));
							respList.add(o);
						}
					}
					transaction.commit();

				}catch(Exception e){
					transaction.rollback();
					throw e;
				}

				return respList;
			}
		});
	}


	/**
	 *
	 * @param entity
	 * @param inputMap
     * @return
     */
	/*@Override
	public List searchTextInColumn(final Class entity, final Map<String, Serializable> inputMap){

		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(entity);
				criteria.add(Restrictions.like(inputMap.get(SIMSConstants.SEARCH_COLUMN).toString(),
						inputMap.get(SIMSConstants.SEARCH_STRING).toString()).ignoreCase());

				DetachedCriteria accountCriteria = DetachedCriteria.forClass(CustomerAccount.class);
				accountCriteria.setProjection(Property.forName("customer"));
				accountCriteria.createAlias("customer.customerId","custAcctId");
				accountCriteria.add(Restrictions.eq("custAcctId", "customerId"));

				criteria.add(Property.forName("customerId").in(accountCriteria));

				criteria.setFirstResult(Integer.parseInt(inputMap.get(SIMSConstants.START_INDEX).toString()) - 1);
				criteria.setMaxResults(Integer.parseInt(inputMap.get(SIMSConstants.PAGE_SIZE).toString()));
				return criteria.list();
			}
		});

	}
*/
	@Override
	public List executeNativeQueryForCount( final String nativeQuery, final Class entity , final Map<String, Serializable> inputMap ) {
		
		return (List) getAdminUIHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {

				Query query = session.createSQLQuery(nativeQuery).addEntity(entity);
				
				Criteria criteria = session.createCriteria(entity);
				
				criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
				return query.list();

			}
		});
	}
	
}