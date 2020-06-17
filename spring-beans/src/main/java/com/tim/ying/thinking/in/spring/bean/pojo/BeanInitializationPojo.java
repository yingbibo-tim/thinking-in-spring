package com.tim.ying.thinking.in.spring.bean.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.RootBeanDefinition;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yingbibo
 * on 2020-06-15
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanInitializationPojo implements InitializingBean, DisposableBean {


	/**
	 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition).applyBeanPostProcessorsBeforeInitialization}
	 */
	@PostConstruct
	public void postConstruct(){
		System.out.println("bean postConstruct");
	}


	/**
	 * {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)}
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean afterPropertiesSet");
	}

	public void initMethod(){
		System.out.println("bean initMethod");

	}

	@PreDestroy
	public void preDestroy(){
		System.out.println("bean preDestroy");
	}

	/**
	 * 销毁bean
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("bean destroy");
	}

	public void destroyMethod()throws Exception{
		System.out.println("bean destroyMethod");
	}
}
