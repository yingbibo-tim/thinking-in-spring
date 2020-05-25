package com.tim.ying.thinking.in.spring.bean.pojo;

/**
 *
 * 用户类
 * @author yingbibo
 * on 2020-05-13
 * email: yingbibo@canzhaoxi.com.cn
 */
public class User {

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
