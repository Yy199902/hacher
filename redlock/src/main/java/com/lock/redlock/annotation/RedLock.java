package com.lock.redlock.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) //注解作用于方法级别
@Retention(RetentionPolicy.RUNTIME) //运行时起作用
public @interface RedLock {
    String redisKey() default "";//redis 锁key
}
