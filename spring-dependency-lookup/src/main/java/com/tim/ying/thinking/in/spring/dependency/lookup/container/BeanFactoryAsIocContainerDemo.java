package com.tim.ying.thinking.in.spring.dependency.lookup.container;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * beanFactory 作为 IOC容器
 * @author yingbibo
 * on 2020-06-03
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanFactoryAsIocContainerDemo {

	public static void main(String[] args) {
		String xmlLocation = "classpath:dependency-lookup-context.xml";
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		int beanCount = beanDefinitionReader.loadBeanDefinitions(xmlLocation);
		System.out.println(beanCount);

	}
}
