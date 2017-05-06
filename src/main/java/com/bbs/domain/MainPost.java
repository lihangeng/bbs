package com.bbs.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 主题帖
 * @author John
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)//设置缓存策略
@Table(name = "t_post")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="post_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("1")
public class MainPost extends Post {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

}
