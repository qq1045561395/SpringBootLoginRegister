package com.soft.wesker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.soft.wesker.dao")
public class SpringBootStarter{
    public static void main(String[] args) {
        //启动SpringBoot工程
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootStarter.class, args);
    }

}
