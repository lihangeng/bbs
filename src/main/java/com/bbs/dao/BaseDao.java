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
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.util.Assert;
/**
 * DAO的基础类，定义了很多公用的方法，子类Dao可以直接用，不需要每个子类再实现一次
 * @author John
 *
 * @param <T>
 */
public class BaseDao<T> {
	
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTempate;
	
	/**
	 * 
	 * @return
	 */
	public HibernateTemplate getHibernateTempate() {
		return hibernateTempate;
	}
	
	public void setHibernateTempate(HibernateTemplate hibernateTempate) {
		this.hibernateTempate = hibernateTempate;
	}

	/**
	 * 
	 * @return
	 */
	public Session getSession() {
		return SessionFactoryUtils.getSession(hibernateTempate.getSessionFactory(), true);
	}
    /**
     * 
     */
	public BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	/**
	 * 根据ID返回实体的一个代理
	 * @param id
	 * @return
	 */
	public T load(Serializable id){
		return getHibernateTempate().load(entityClass, id);
	}
	/**
	 * 根据ID返回一个实体
	 * @param id
	 * @return
	 */
	public T get(Serializable id){
		return getHibernateTempate().get(entityClass, id);
	}
	/*hibernate的get/load的根本区别分为4点：
	 * 第一点是：load会抛出异常，get会返回空，一般采用的load方法。
	 * 第二点是：get只返回实体对象实例。而load返回的是代理类实体对象实例。
	 * 第三点是：get方法只能使用一级缓存。而load可以使用一级和二级缓存。
	 * 第四点是：都是通过id得到单个对象的方法
	 */
	/**
	 * 返回所有实体
	 * @return
	 */
	public List<T> loadAll(){
		return getHibernateTempate().loadAll(entityClass);
	}
	/**
	 * 持久化一个实体到数据库中
	 * @param entity
	 */
	public void save(T entity){
		getHibernateTempate().save(entity);
	}
	/**
	 * 从数据库中删除一个实体对应的记录
	 * @param entity
	 */
	public void remove(T entity){
		getHibernateTempate().delete(entity);
	}
	/**
	 * 更新实体到数据库中
	 * @param entity
	 */
	public void update(T entity){
		getHibernateTempate().update(entity);
	}
	/**
	 * 根据sql语句返回一个List
	 * @param sql
	 * @return
	 */
	public List find(String hql){
		return getHibernateTempate().find(hql);
	}
	/**
	 * 根据Sql和参数返回一个List
	 * @param sql
	 * @param params
	 * @return
	 */
	public List find(String hql,Object...params){
		return getHibernateTempate().find(hql, params);
	}
	/**
	 * 强制初始化
	 * @param entity
	 */
	public void initalize(Object entity){
		getHibernateTempate().initialize(entity);
	}
	/**
	 * 分页查询函数，使用hql
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @param values
	 * @return
	 */
	public Page pagedQuery(String hql,int pageNo,int pageSize,Object...values){
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
	 * 创建query对象
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
	 * 去除hql的select字句
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
	 * 去除hql的group子句
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
