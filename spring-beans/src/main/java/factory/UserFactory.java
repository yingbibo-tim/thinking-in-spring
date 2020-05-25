package factory;

import com.tim.ying.thinking.in.spring.bean.pojo.User;

/**
 * {@link User} 工厂类
 * @author yingbibo
 * on 2020-05-13
 * email: yingbibo@canzhaoxi.com.cn
 */
public interface UserFactory {

	/**
	 * 用户创建
	 * @return User
	 */
	default User createUser(){
		User user = new User();
		user.setId(1L);
		user.setName("tim");
		return user;
	}
}
