package com.bbs.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

public class BaseDao<T> {
	
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTempate;
	
	public HibernateTemplate getHibernateTempate() {
		return hibernateTempate;
	}
	
	public BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	public T load(Serializable id){
		return getHibernateTempate().load(entityClass, id);
	}
	
	public T get(Serializable id){
		return getHibernateTempate().get(entityClass, id);
	}
	
	public List<T> loadAll(){
		return getHibernateTempate().loadAll(entityClass);
	}
	
	public void save(T entity){
		getHibernateTempate().save(entity);
	}
	
	public void remove(T entity){
		getHibernateTempate().delete(entity);
	}
	
	public void update(T entity){
		getHibernateTempate().update(entity);
	}
	
	public List find(String sql){
		return getHibernateTempate().find(sql);
	}
	
	public List find(String sql,Object...params){
		return getHibernateTempate().find(sql, params);
	}
	
	public void initalize(Object entity){
		getHibernateTempate().initialize(entity);
	}
	
	public Page pagedQuery(String sql,int pageNo,int pageSize,Object...values){
		/*
		 * notNull(Object object) 
                                     当 object 不为 null 时抛出异常
           isTrue(boolean expression) / isTrue(boolean expression, String message) 
                                     当 expression 不为 true 抛出异常                      
           notEmpty(Collection collection) / notEmpty(Collection collection, String message) 
                                     当集合未包含元素时抛出异常                      
           hasLength(String text) / hasLength(String text, String message) 
                                       当 text 为 null 或长度为 0 时抛出异常             
           hasText(String text) / hasText(String text, String message) 
             text 不能为 null 且必须至少包含一个非空格的字符，否则抛出异常；
           isInstanceOf(Class clazz, Object obj) / isInstanceOf(Class type, Object obj, String message) 
                                       如果 obj 不能被正确造型为 clazz 指定的类将抛出异常；
           isAssignable(Class superType, Class subType) / isAssignable(Class superType, Class subType, String message) 
             subType 必须可以按类型匹配于 superType，否则将抛出异常；         
		 */
		Assert.hasText(sql);
		return null;
		
	}

}
