package com.tim.ying.thinking.in.spring.dependency.lookup.pojo;

import com.tim.ying.thinking.in.spring.dependency.lookup.annotation.Super;

/**
 * @author yingbibo
 * on 2020-05-25
 * email: yingbibo@canzhaoxi.com.cn
 */
@Super
public class SuperUser extends User {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;


	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
