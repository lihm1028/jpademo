package com.springdemo.jpademo.support;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author li.hongming
 * @date 2023/8/7
 */
@Slf4j
public class SqlExecutionInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        if (invocation.getMethod().getName().startsWith("execute")) {
            Connection connection = (Connection) invocation.getThis();
            String sql = (String) invocation.getArguments()[0];
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println(sql); // 在日志中打印SQL语句
            log.info(sql);
        }
        result = invocation.proceed();
        return result;
    }

}
