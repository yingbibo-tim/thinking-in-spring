package com.tim.ying.thinking.in.spring.dependency.lookup.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * ApplicationContext 作为 IOC容器
 * @author yingbibo
 * on 2020-06-03
 * email: yingbibo@canzhaoxi.com.cn
 */
public class ApplicationAsIocContainerDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ApplicationAsIocContainerDemo.class);
		applicationContext.refresh();

		System.out.println(applicationContext.getBeansOfType(String.class));

		applicationContext.close();
	}

	@Bean
	public String hello(){
		return "hello";
	}
	@Bean
	public String world(){
		return "world";
	}
}
