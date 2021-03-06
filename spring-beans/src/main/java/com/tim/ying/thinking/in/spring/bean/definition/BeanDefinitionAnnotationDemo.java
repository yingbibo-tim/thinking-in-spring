package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * AnnotationContext 注解定义Bean的方式三种常规方式
 * 1. @Component 及派生类
 * 2. @Bean 注解
 * 3. @Import 注解
 * @author yingbibo
 * on 2020-06-11
 * email: yingbibo@canzhaoxi.com.cn
 */
@Import(value = {BeanDefinitionAnnotationDemo.Config.class,ImportConfig.class})
public class BeanDefinitionAnnotationDemo {


	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanDefinitionAnnotationDemo.class);
		applicationContext.refresh();

		registerByBeanDefinitionBuilder(applicationContext,"anotherUser");
		registerByBeanDefinitionBuilder(applicationContext,null);

		System.out.println("BeanDefinitionAnnotationDemo bean - > " + applicationContext.getBeansOfType(BeanDefinitionAnnotationDemo.class));
		System.out.println("Config bean - > " + applicationContext.getBeansOfType(Config.class));
		System.out.println("User bean - > " + applicationContext.getBeansOfType(User.class));
		System.out.println("ImportConfig bean - > " + applicationContext.getBeansOfType(ImportConfig.class));
		applicationContext.close();
	}



	public static void registerByBeanDefinitionBuilder(BeanDefinitionRegistry registry,String beanName){
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class)
				.addPropertyValue("id",2L).addPropertyValue("name","JAVA-TIM");

		if(StringUtils.hasText(beanName)){
			registry.registerBeanDefinition(beanName,builder.getBeanDefinition());
		}else{
			BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(),registry);
		}

	}

	@Component
	public static class Config{

		/**
		 * {@link org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsForBeanMethod()}作为方法注入
		 * 如果@bean 上面没有 name字段
		 * 则methodName 作为beanName
		 * @return User
		 */
		@Bean
		public User user(){
			User user = new User();
			user.setId(1L);
			user.setName("tim");
			return user;
		}
	}


}
  class ImportConfig{

}
