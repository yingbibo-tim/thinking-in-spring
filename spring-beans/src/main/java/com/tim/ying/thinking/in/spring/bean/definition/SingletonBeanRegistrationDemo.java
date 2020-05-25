package com.tim.ying.thinking.in.spring.bean.definition;

import factory.DefaultUserFactory;
import factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * spring bean 注册
 * 外部单体注册
 *
 * @author yingbibo
 * on 2020-05-12
 * email: yingbibo@canzhaoxi.com.cn
 */
public class SingletonBeanRegistrationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SingletonBeanRegistrationDemo.class);
		applicationContext.refresh();
		ConfigurableListableBeanFactory configurableListableBeanFactory = applicationContext.getBeanFactory();
		UserFactory userFactory = new DefaultUserFactory();
		configurableListableBeanFactory.registerSingleton("userFactory", userFactory);

		UserFactory getUserFactory = applicationContext.getBean("userFactory", UserFactory.class);

		System.out.println(getUserFactory == userFactory);


		System.out.println(applicationContext.getBean(UserFactory.class));
		applicationContext.close();


	}

	@Bean
	@Primary //primary定义的话 则根据类型查找bean的时候，取值
	public UserFactory getUserFactory() {
		return new DefaultUserFactory();

	}
}
