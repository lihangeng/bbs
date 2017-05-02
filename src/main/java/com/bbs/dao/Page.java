package com.bbs.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象，包含当前页数据及分页信息如总记录数
 * @author John
 *
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int DEFAULT_PAGE_SIZE=20;
	private int pageSize = DEFAULT_PAGE_SIZE;//每页的记录数
	private long start;//当前页第一条数据在List中的位置
	private List date;//当前页存放的记录，一般为list
	private long totalCount;//总记录数
	
	/**
	 * 构造方法，构造空页
	 */
	public Page(){
		this(0,0,DEFAULT_PAGE_SIZE,new ArrayList());
	}
	/**
	 * 默认构造方法
	 * @param start
	 * @param totalSize
	 * @param pageSize
	 * @param date
	 */
	public Page(long start,long totalSize,int pageSize,List date){
		this.start=start;
		this.totalCount = totalSize;
		this.pageSize = pageSize;
		this.date = date;
	}
	/**
	 * 获取总页数
	 * @return
	 */
	public long getTotalPageCount(){
		if(totalCount%pageSize == 0){
			return totalCount/pageSize;
		}else{
			return totalCount/pageSize+1;
		}
	}
	/**
	 * 获取该页当前的页码 页码从1开始
	 * @return
	 */
	public long getCurrentPageNo(){
		return start/pageSize + 1;
	}
	/**
	 * 判断该页是否还有下一页
	 * @return
	 */
	public boolean isHasNextPage(){
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	/**
	 * 判断该页是否还有上一页
	 * @return
	 */
	public boolean isHasPreviousPage(){
		return this.getCurrentPageNo() > 1;
	}
	
	/**
	 * 获取任意页第一条数据在数据集中的位置，每页条数使用默认值
	 * @param pageNo
	 * @return
	 */
	protected static int getStartOfPage(int pageNo){
		
		return getStartPage(pageNo,DEFAULT_PAGE_SIZE);
		
	}
	/**
	 * 获取任意页第一条数据在数据集中的位置
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static int getStartPage(int pageNo,int pageSize){
		return (pageNo-1)*pageSize;
	}
	
	

}
