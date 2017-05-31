package com.sims.genaric.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;



/**
 * Interface is used to define collection, save, update and delete methods.
 * 
 * @author sathyam sreeram
 */


public interface GenaricDAO {
		
	public Object saveOrUpdateEntity(Object entity);

	public Object saveOrUpdateEntityUsingFilter(final Object entity, final String filterName, final String filterColumnName, final String filterString);

	public void saveOrUpdateEntityList(final List<?> entities);

	public Object saveOrUpdateEntityByTransaction(final Object entity);
	
	public void deleteEntityById(Class entity, Integer id) throws Exception;
	
	public void deleteEntityById(Class entity, String id);
	
	public Object findEntityById(Class clz, Integer id);
	
	public Object findEntityById(Class clz, String id);

	public List executeNativeQuery( final String nativeQuery , final Class entity);

	public List executeNamedQuery( String namedQuery ,  Class entity,  String input);

	public List executeNativeQuery( String nativeQuery , Class entity , String input);

	public List executeNamedQuery(Class entity);

	public List executeListByNativeQuery(String nativeQuery, String columnName , Class entity, List<String> inputValues);
	
	public int executeUpdateOrDeleteByNativeQuery(final String nativeQuery , final String inputName , final List<String> inputValues);
	
	public Object executeCriteriaWithCondition(Class entity, String conditionColumnName, Object inputValue);

	public List executeCriteriaListWithCondition(Class entity, String conditionColumnName,Object inputValue);

	public List executeCriteriaListWithMultipleConditionInput(final Class entity, final String conditionColumnName, final List inputValue);

	public void deleteEntity(final Object entity);

	public Object loadEntity(Class theClass, Serializable id);

	public List executeCriteria(Class entity, Map<String, Serializable> columnValues);
	
	public List executeFilterCriteria(final Class entity,  final Map<String, Serializable> inputMap );
	
	public List executeFilterCriteriaByPagination(final Class entity,  final Map<String, Serializable> inputMap );

	public int executeUpdateOrDeleteByNativeQuery(String nativeQuery,Map<String, Serializable> columnValues);

	public List executeNativeQuery(String nativeQuery);

	public List executeNamedQueryByCriteria( final Class entity , final Map<String, Serializable> inputMap);
	
	public List executeNamedQueryByPagination( final Class entity , final Map<String, Serializable> inputMap);
	
	public Number getRowCountByEntity( final Class entity ) ;

	public Number getRowCountByEntity( final String hql );

	public List executeSelectByNamedQuery( final String hql, final  Map<String, Serializable> inputMap );

	public List executeSelectByFilter( final Class entity, final String filterName, final String filterColumn, final String filterString, final String columnName, final String input );

	public List executeNamedQueryByPagination(final String hql , final  Map<String, Serializable> inputMap );
	
	public int executeUpdateOrDeleteByNamedQuery(final String hql , final Map<String,Serializable> inputMap);

	//public List searchTextInColumn(final Class entity, final Map<String, Serializable> inputMap);
	
	public List executeSelectByCriteria( final Class entity, final String joinEntityName , final  Map<String, Serializable> inputMap ); 
	
	public List executeSelectByNamedQuery( final String hql );

	public List executeCriteriaWithPagingAndSorting(Class entity, Map<String, Serializable> inputMap);

	public List executeNativeQueryByPagination(String nativeQuery, Class entity, final Map<String, Serializable> inputMap);

	public List executeNativeQueryForCount( final String nativeQuery, final Class entity , final Map<String, Serializable> inputMap );
	
	public List executeNamedQueryByPagination(final String hql  );

	public List executeMultipleOperation(final Map<String, Serializable> stringObjectMap);

}