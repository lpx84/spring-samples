package com.percylee.spring.cache.annotantion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 支持class和method
 *
 * @author 李鹏翔(lipengxiang1)
 * @date 2019/7/11
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheExpire {

    /**
     * 过期时间
     *
     * @return
     */
    long value() default 60L;

    /**
     * 时间单位，默认为秒
     * 只支持：SECONDS,MINUTES,HOURS,DAYS
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
