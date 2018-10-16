package com.yuri.ynweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.yuri.ynweb.dao")
@ComponentScan(basePackages = {"com.yuri.ynweb.*"})

public class YnwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YnwebApplication.class, args);
    }
}
