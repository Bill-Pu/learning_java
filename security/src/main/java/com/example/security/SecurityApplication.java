package com.example.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.security.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class, args);
        System.out.println("");
    }

}
