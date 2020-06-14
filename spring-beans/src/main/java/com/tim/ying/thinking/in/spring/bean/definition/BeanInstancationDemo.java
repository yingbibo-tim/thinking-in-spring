package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.User;
import factory.DefaultUserFactory;
import factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yingbibo
 * on 2020-06-13
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanInstancationDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/dependency-bean-instancation-context.xml");
		System.out.println(" by User method ==> " + applicationContext.getBean("instance-by-method", User.class));
		System.out.println(" by DefaultFactory method ==> " + applicationContext.getBean("instance-by-factory", User.class));
		System.out.println(" by UserFactoryBean ==> " + applicationContext.getBean("instance-by-factory-bean", User.class));
		serviceLoaderFactoryBeanDemo(applicationContext);
		autowireCapableBeanFactory(applicationContext.getAutowireCapableBeanFactory());
	}


	/**
	 * {@link org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean}实现
	 */
	public static void serviceLoaderFactoryBeanDemo(ApplicationContext applicationContext){
		ServiceLoader<UserFactory> userFactoryServiceLoader = ServiceLoader.load(UserFactory.class,Thread.currentThread().getContextClassLoader());
		{

			for (UserFactory userFactory : userFactoryServiceLoader) {
				System.out.println(userFactory.toString() + " : " + userFactory.createUser());
			}

		}

		{

			ServiceLoader<UserFactory> serviceLoaderFactoryBean = applicationContext.getBean("serviceLoaderUserFactory", ServiceLoader.class);
			Iterator<UserFactory> it = serviceLoaderFactoryBean.iterator();
			while (it.hasNext()) {
				UserFactory userFactory = it.next();
				System.out.println(userFactory.toString() + " : " + userFactory.createUser());
			}
		}

		{
			ServiceLoader<UserFactory> serviceLoaderFactoryBean = applicationContext.getBean("serviceLoaderUserFactory", ServiceLoader.class);
			Iterator<UserFactory> it = serviceLoaderFactoryBean.iterator();
			while (it.hasNext()){
				UserFactory userFactory = it.next();
				System.out.println(userFactory.toString() + " : " + userFactory.createUser());
			}
		}
	}

	/**
	 * {@link AutowireCapableBeanFactory} 例子
	 * @param beanFactory
	 */
	public static void autowireCapableBeanFactory(AutowireCapableBeanFactory beanFactory){
		DefaultUserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
		System.out.println(userFactory.toString() + " : " + userFactory.createUser());
	}
}
