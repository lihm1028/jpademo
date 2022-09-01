package com.springdemo.jpademo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaDemoApplicaiton {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(JpaDemoApplicaiton.class)
                .run(args);

        System.out.println("启动端口:" + context.getEnvironment().getProperty("server.port"));

    }
}
