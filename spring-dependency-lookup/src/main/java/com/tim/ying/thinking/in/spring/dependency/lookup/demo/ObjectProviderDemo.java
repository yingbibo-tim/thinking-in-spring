package com.tim.ying.thinking.in.spring.dependency.lookup.demo;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Iterator;

/**{@link org.springframework.beans.factory.ObjectProvider} 使用示例
 * @author yingbibo
 * on 2020-05-19
 * email: yingbibo@canzhaoxi.com.cn
 */
public class ObjectProviderDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ObjectProviderDemo.class);
		applicationContext.refresh();

		lookupByObjectProvider(applicationContext);
		lookupByObjectProviderIfAvailable(applicationContext);
		lookupByObjectProviderIterator(applicationContext);
		applicationContext.close();
	}

	/**
	 * {@link ObjectProvider#iterator()} 使用示例
	 * @param applicationContext beanFactory
	 */
	private static void lookupByObjectProviderIterator(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
		Iterator<String> iterator =  objectProvider.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		for(String str: objectProvider){
			System.out.println(str);
		}

		objectProvider.stream().forEach(System.out::println);



	}

	/**
	 * 存在则取出,不存在则兜底
	 * @param applicationContext beanFactory
	 */
	private static void lookupByObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<Integer> objectProvider = applicationContext.getBeanProvider(Integer.class);
		Integer i = objectProvider.getIfAvailable(()->1);
		System.out.println(i);
	}

	private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
		System.out.println(objectProvider.getObject());
	}


	@Bean
	@Primary
	public String helloWorld(){
		return "helloWorld";
	}

	@Bean
	public String message(){
		return "message";
	}
}
