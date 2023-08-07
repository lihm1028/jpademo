package com.springdemo.jpademo.config;

import com.springdemo.jpademo.config.annotation.MyMethodAnnotation;
import org.aspectj.weaver.patterns.AnnotationPointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
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
//    @Bean
//    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
//          String traceExecution="execution(* com.springdemo.jpademo.*.*(..))";
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression(traceExecution);
//        // 配置增强类advisor
//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//        advisor.setPointcut(pointcut);
//        advisor.setAdvice(new MyMethodInterceptor());
//        return advisor;
//    }


    /**
     * 案例三： 注解方式构造切入点
     * @return
     */
//    @Bean
//    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
////        String traceExecution="execution(* com.springdemo.jpademo.*.*(..))";
//        String traceExecution = "@annotation(com.springdemo.jpademo.config.annotation.MyMethodAnnotation)";
//
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression(traceExecution);
//        // 配置增强类advisor
//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//        advisor.setPointcut(pointcut);
//        advisor.setAdvice(new MyMethodInterceptor());
//        return advisor;
//    }


    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        // 注解方式
       // AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(MyMethodAnnotation.class, true);

        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null,MyMethodAnnotation.class);
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(new MyMethodInterceptor());
        return advisor;
    }



}
