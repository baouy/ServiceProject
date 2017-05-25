package com.tudou.common.annotation;

import java.lang.annotation.*;

/**
 * 初始化继承BaseService的service
 * Created by DavidWang on 2017/5/25.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
