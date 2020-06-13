package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


	}
}
