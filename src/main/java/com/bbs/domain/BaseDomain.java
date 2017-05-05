package com.bbs.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDomain implements Serializable {
	
	/**
	 * Dao基础类
	 */
	private static final long serialVersionUID = 1L;

	public String toString(){
		
		return ToStringBuilder.reflectionToString(this);//返回对象和属性的值
		
	}

}
