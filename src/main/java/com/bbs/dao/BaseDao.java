package com.bbs.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

public class BaseDao<T> {
	
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTempate;
	
	@Autowired
	private Session session;
	
	public HibernateTemplate getHibernateTempate() {
		return hibernateTempate;
	}
	
	public Session getSession() {
		return session;
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
	/**
	 * ��ҳ��ѯ������ʹ��hql
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @param values
	 * @return
	 */
	public Page pagedQuery(String hql,int pageNo,int pageSize,Object...values){
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
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 1,"pageNo shoud start form 1");
		String countQueryString = "select count(*)"+removeSelect(removeOrders(hql));
		List countlist = getHibernateTempate().find(countQueryString,values);
		long totalCount = (Long)countlist.get(0);
		if(totalCount < 1)
			return new Page();
			int startIndex = Page.getStartPage(pageNo,pageSize);
			Query query = createQuery(hql,values);
			List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
			return new Page(startIndex,totalCount,pageSize,list);
	}
	/**
	 * ����query����
	 * @param hql
	 * @param values
	 * @return
	 */
	public Query createQuery(String hql,Object...values){
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for(int i=0;i<values.length;i++){
			query.setParameter(i, values[i]);
		}
		return query;
	}
	/**
	 * ȥ��hql��select�־�
	 * @param hql
	 * @return
	 */
	private static String removeSelect(String hql){
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, "hql:"+hql+"must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	/**
	 * ȥ��hql��group�Ӿ�
	 * @param hql
	 * @return
	 */
	private static String removeOrders(String hql){
		Assert.hasText(hql);
	    Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",Pattern.CASE_INSENSITIVE);
	    Matcher m = p.matcher(hql);
	    StringBuffer sb = new StringBuffer();
	    while(m.find()){
	    	m.appendReplacement(sb, "");
	    }
	    m.appendTail(sb);
	    return sb.toString();
	}

}
