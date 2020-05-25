package com.tim.ying.thinking.in.spring.dependency.lookup.demo;

import com.tim.ying.thinking.in.spring.dependency.lookup.annotation.Super;
import com.tim.ying.thinking.in.spring.dependency.lookup.pojo.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**依赖查找
 * 根据名称查找 {@link #lookupByName(BeanFactory)}
 * 根据类型查询 {@link #lookupByType(BeanFactory)}
 * 根据类型集合查找 {@link #lookupCollectionByType(ApplicationContext)}
 * 根据注解集合查找 {@link #lookupByAnnotation(ApplicationContext)}
 * @author yingbibo
 * on 2020-05-25
 * email: yingbibo@canzhaoxi.com.cn
 */
public class LookupDemo {

	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:dependency-look-up-context.xml");
		lookupByName(beanFactory);
		lookupByType(beanFactory);
		lookupCollectionByType(beanFactory);
		lookupByAnnotation(beanFactory);
	}

	private static void lookupByAnnotation(ApplicationContext beanFactory) {
		Map<String,User> map = (Map)beanFactory.getBeansWithAnnotation(Super.class);
		System.out.println("lookupByAnnotation = > "+map);
	}

	private static void lookupCollectionByType(ApplicationContext beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			Map<String, User> userMap = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
			System.out.println("lookupCollectionByType = > " + userMap);
		}
	}


	private static void lookupByName(BeanFactory beanFactory) {
		User user = (User) beanFactory.getBean("user");
		System.out.println("lookupByName = > " + user);
	}

	private static void lookupByType(BeanFactory beanFactory) {
		User user = beanFactory.getBean(User.class);
		System.out.println("lookupByType = > " + user);
	}
}
