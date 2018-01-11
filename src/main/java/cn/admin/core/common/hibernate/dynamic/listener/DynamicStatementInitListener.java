package cn.admin.core.common.hibernate.dynamic.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import cn.admin.core.common.hibernate.dynamic.builder.DynamicHibernateStatementBuilder;
import cn.admin.core.common.hibernate.dynamic.builder.NoneDynamicHibernateStatementBuilder;
import cn.admin.core.utils.SpringContextHolder;

public class DynamicStatementInitListener implements ApplicationListener<ContextRefreshedEvent> {

	protected DynamicHibernateStatementBuilder dynamicStatementBuilder = SpringContextHolder.getApplicationContext()
			.getBean(DynamicHibernateStatementBuilder.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			if (this.dynamicStatementBuilder == null) {
				this.dynamicStatementBuilder = new NoneDynamicHibernateStatementBuilder();
			}
			dynamicStatementBuilder.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}