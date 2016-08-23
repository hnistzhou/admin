package com.gtja.app.operation.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zhoubo on 16/7/19.
 */
@SpringBootApplication
@MapperScan("com.gtja.app.operation.service.mapper")
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
