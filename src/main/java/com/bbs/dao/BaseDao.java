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
                                     �� object ��Ϊ null ʱ�׳��쳣
           isTrue(boolean expression) / isTrue(boolean expression, String message) 
                                     �� expression ��Ϊ true �׳��쳣                      
           notEmpty(Collection collection) / notEmpty(Collection collection, String message) 
                                     ������δ����Ԫ��ʱ�׳��쳣                      
           hasLength(String text) / hasLength(String text, String message) 
                                       �� text Ϊ null �򳤶�Ϊ 0 ʱ�׳��쳣             
           hasText(String text) / hasText(String text, String message) 
             text ����Ϊ null �ұ������ٰ���һ���ǿո���ַ��������׳��쳣��
           isInstanceOf(Class clazz, Object obj) / isInstanceOf(Class type, Object obj, String message) 
                                       ��� obj ���ܱ���ȷ����Ϊ clazz ָ�����ཫ�׳��쳣��
           isAssignable(Class superType, Class subType) / isAssignable(Class superType, Class subType, String message) 
             subType ������԰�����ƥ���� superType�������׳��쳣��         
		 */
		Assert.hasText(sql);
		return null;
		
	}

}
