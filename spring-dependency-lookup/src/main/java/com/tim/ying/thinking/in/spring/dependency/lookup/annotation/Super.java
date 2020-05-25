package com.tim.ying.thinking.in.spring.dependency.lookup.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**{@link com.tim.ying.thinking.in.spring.dependency.lookup.pojo.SuperUser} 上的主键
 * @author yingbibo
 * on 2020-05-25
 * email: yingbibo@canzhaoxi.com.cn
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
