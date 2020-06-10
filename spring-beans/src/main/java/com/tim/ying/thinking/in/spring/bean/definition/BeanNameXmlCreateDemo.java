package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * {@link org.springframework.beans.factory.support.DefaultBeanNameGenerator}
 *
 * xml 里面没有定义id 或者name的时候 生成的beanName
 * @author yingbibo
 * on 2020-06-10
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanNameXmlCreateDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/dependency-bean-name-create-context.xml");


		System.out.println(applicationContext.getBeansOfType(User.class));
	}
}
