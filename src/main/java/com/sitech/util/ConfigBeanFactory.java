package com.sitech.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigBeanFactory {

	private static ApplicationContext factory;
	static {
		//factory = new ClassPathXmlApplicationContext(new String[]{"springConfig/cassandra.xml"});
	}

	public static ApplicationContext getFactory() {
		return factory;
	}

	public static Object getBean(String bean_name) {
		return null;
		//return factory.getBean(bean_name);
	}

	public static void main(String[] args) {
		
		Object obj = factory.getBean("baseDao");
		System.out.println("salesTest: " + obj);

	}

}
