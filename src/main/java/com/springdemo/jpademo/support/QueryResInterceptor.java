package com.springdemo.jpademo.support;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;

@Slf4j
public class QueryResInterceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        log.info("QueryResInterceptor打印sql={}", sql);
        String statement = super.onPrepareStatement(sql);
        log.info("QueryResInterceptor打印sql={}", statement);
        return statement;
    }
}
