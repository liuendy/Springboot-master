package com.master.log;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SpringContextUtil 
 * @Description: Spring获取JavaBean工具类
 * @author aquarius
 * @date 2016年4月25日 下午4:38:04 
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/** 
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境 
	 *  
	 * @param applicationContext 
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/** 
	 * @return ApplicationContext 
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/** 
	 * 获取对象 
	 * @param name 
	 * @return Object
	 * @throws BeansException 
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	/**
	 * 通过class获取Bean.
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}

	/**
	 * 通过name,以及Clazz返回指定的Bean
	 * @param name
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(String name,Class<T> clazz){
		return applicationContext.getBean(name, clazz);
	}
}
