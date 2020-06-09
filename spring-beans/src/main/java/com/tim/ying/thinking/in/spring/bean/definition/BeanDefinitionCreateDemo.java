package com.tim.ying.thinking.in.spring.bean.definition;

import com.tim.ying.thinking.in.spring.bean.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 *
 * {@link org.springframework.beans.factory.support.BeanDefinitionBuilder} 方式创建bean
 * @author yingbibo
 * on 2020-06-09
 * email: yingbibo@canzhaoxi.com.cn
 */
public class BeanDefinitionCreateDemo {

	public static void main(String[] args) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("id",1L);
		beanDefinitionBuilder.addPropertyValue("name","tim");
		BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		System.out.println(beanDefinition);


		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(User.class);
		MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
		mutablePropertyValues.add("id",1L).add("name","tim");
		genericBeanDefinition.setPropertyValues(mutablePropertyValues);
		System.out.println(genericBeanDefinition);

	}
}
