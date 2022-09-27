package com.example.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.")

public class SecurityApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class, args);
        System.out.println("");
    }

}
