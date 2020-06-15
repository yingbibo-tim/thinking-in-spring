package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.BeanInitializationPojo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean初始化 例子
 * 1.{@link @javax.annotation.PostConstruct}
 * 2. initMethod
 * 3.
 *
 *
 * @author yingbibo
 * on 2020-06-15
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanInitializationDemo {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanInitializationDemo.class);
		applicationContext.refresh();
		applicationContext.getBean(BeanInitializationPojo.class);
		applicationContext.close();
	}

	@Bean(initMethod = "initMethod")
	public BeanInitializationPojo beanInitializationPojo(){
		return new BeanInitializationPojo();
	}


}
