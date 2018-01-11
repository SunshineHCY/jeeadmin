package cn.admin.core.common.hibernate.dynamic.builder;

import java.io.IOException;

/**
 * 动态sql/hql语句组装器
 * 
 * @author  administrator
 * 
 */
public interface DynamicHibernateStatementBuilder {

	/**
	 * 初始化
	 * 
	 * @throws IOException
	 */
	public void init() throws IOException;
}