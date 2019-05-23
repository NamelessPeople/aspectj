package com.github.namelesspeople.aspectjdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类描述：
 * 创建人： 张力
 * 创建时间： 2018/9/11
 * 版权： 成都智慧一生约科技有限公司
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Intercept {
}
