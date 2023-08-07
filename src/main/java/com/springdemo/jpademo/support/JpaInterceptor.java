package com.springdemo.jpademo.support;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.jdbc.spi.StatementInspector;

@Slf4j
public class JpaInterceptor implements StatementInspector {

    @Override
    public String inspect(String sql) {
        log.info("JpaInterceptor打印sql={}", sql);
        return sql;

    }
}
