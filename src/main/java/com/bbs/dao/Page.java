package com.bbs.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ���󣬰�����ǰҳ���ݼ���ҳ��Ϣ���ܼ�¼��
 * @author John
 *
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int DEFAULT_PAGE_SIZE=20;
	private int pageSize = DEFAULT_PAGE_SIZE;//ÿҳ�ļ�¼��
	private long start;//��ǰҳ��һ��������List�е�λ��
	private List date;//��ǰҳ��ŵļ�¼��һ��Ϊlist
	private long totalCount;//�ܼ�¼��
	
	/**
	 * ���췽���������ҳ
	 */
	public Page(){
		this(0,0,DEFAULT_PAGE_SIZE,new ArrayList());
	}
	/**
	 * Ĭ�Ϲ��췽��
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
	 * ��ȡ��ҳ��
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
	 * ��ȡ��ҳ��ǰ��ҳ�� ҳ���1��ʼ
	 * @return
	 */
	public long getCurrentPageNo(){
		return start/pageSize + 1;
	}
	/**
	 * �жϸ�ҳ�Ƿ�����һҳ
	 * @return
	 */
	public boolean isHasNextPage(){
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	/**
	 * �жϸ�ҳ�Ƿ�����һҳ
	 * @return
	 */
	public boolean isHasPreviousPage(){
		return this.getCurrentPageNo() > 1;
	}
	
	/**
	 * ��ȡ����ҳ��һ�����������ݼ��е�λ�ã�ÿҳ����ʹ��Ĭ��ֵ
	 * @param pageNo
	 * @return
	 */
	protected static int getStartOfPage(int pageNo){
		
		return getStartPage(pageNo,DEFAULT_PAGE_SIZE);
		
	}
	/**
	 * ��ȡ����ҳ��һ�����������ݼ��е�λ��
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static int getStartPage(int pageNo,int pageSize){
		return (pageNo-1)*pageSize;
	}
	
	

}
