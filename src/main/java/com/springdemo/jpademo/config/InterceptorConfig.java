package com.springdemo.jpademo.config;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author li.hongming
 * @date 2023/8/7
 */
@Configuration
public class InterceptorConfig {


    /**
     * 案例一：非注解
     * JdkRegexpMethodPointcut来构造切点
     * @return
     */
//    @Bean
//    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
//        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//        pointcut.setPattern("com.springdemo.jpademo.*");
//
//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//        advisor.setPointcut(pointcut);
//        advisor.setAdvice(new MyMethodInterceptor());
//        System.out.println(advisor.toString());
//        return advisor;
//    }


    /**
     * 案例二：AspectJExpressionPointcut 构造切入点
     * @return
     */
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
          String traceExecution="execution(* com.springdemo.jpademo.*.*(..))";
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(traceExecution);
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(new MyMethodInterceptor());
        return advisor;
    }

}
