package com.bbs.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao<T> {
	
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTempate;
	
	public BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	public T load(Serializable id){
		return hibernateTempate.load(entityClass, id);
	}
	
	public T get(Serializable id){
		return hibernateTempate.get(entityClass, id);
	}
	
	public List<T> loadAll(){
		return hibernateTempate.loadAll(entityClass);
	}
	
	public void save(T entity){
		hibernateTempate.save(entity);
	}
	
	public void remove(T entity){
		hibernateTempate.delete(entity);
	}
	
	public void update(T entity){
		hibernateTempate.update(entity);
	}
	
	public List find(String sql){
		return hibernateTempate.find(sql);
	}
	
	public List find(String sql,Object...params){
		return hibernateTempate.find(sql, params);
	}
	
	public void initalize(Object entity){
		hibernateTempate.initialize(entity);
	}

}
