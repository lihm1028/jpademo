package com.springdemo.jpademo.config.annotation;

import java.lang.annotation.*;

/**
 * @author li.hongming
 * @date 2023/8/7
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyMethodAnnotation {

}
