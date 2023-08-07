package com.springdemo.jpademo.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author li.hongming
 * @date 2023/8/7
 */
@Slf4j
public class MyMethodInterceptor2 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(invocation.getMethod().getName());
        log.info("MyMethodInterceptor2："+invocation.getMethod().getName());
        log.info("MyMethodInterceptor2："+invocation.getMethod().isVarArgs());
        return invocation.proceed();
    }
}
