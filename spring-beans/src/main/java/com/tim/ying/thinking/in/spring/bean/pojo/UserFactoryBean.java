package com.tim.ying.thinking.in.spring.bean.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * {@link FactoryBean }的User实例化
 * @author yingbibo
 * on 2020-06-13
 * email: yingbibo@canzhaoxi.com.cn
 */
public class UserFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
		User user = new User();
		user.setId(3L);
		user.setName("create by FactroyBean");
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
