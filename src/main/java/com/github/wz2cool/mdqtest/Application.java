package com.github.wz2cool.mdqtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Frank
 * \* Date: 8/14/2017
 * \* Time: 5:48 PM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@SpringBootApplication
@MapperScan(basePackages = "com.github.wz2cool.mdqtest.mapper")
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}