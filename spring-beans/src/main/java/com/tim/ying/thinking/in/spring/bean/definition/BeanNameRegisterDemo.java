package com.tim.ying.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * beanName 注册规则 主要用于annotation
 * @author yingbibo
 * on 2020-05-16
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanNameRegisterDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanNameRegisterDemo.class,BeanNameAnnotation.class,BeanName.class);
		applicationContext.refresh();
		System.out.println(applicationContext.getBeansOfType(BeanName.class));
		System.out.println(applicationContext.getBeansOfType(BeanNameAnnotation.class));
		applicationContext.close();
	}

	@Component
	public class BeanName{

	}
}

@Component
class BeanNameAnnotation{
	private String id;
	private String name;
}
