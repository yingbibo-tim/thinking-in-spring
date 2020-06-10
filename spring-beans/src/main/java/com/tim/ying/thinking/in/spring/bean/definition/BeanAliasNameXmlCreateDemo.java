package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 *
 * xml 别名
 * @author yingbibo
 * on 2020-06-10
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanAliasNameXmlCreateDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/dependency-bean-alias-name-context.xml");
		System.out.println(applicationContext.getBean("user"));
		System.out.println(applicationContext.getBean("aliasUser"));
		System.out.println(applicationContext.getBean("aliasUser1"));

	}
}
