package com.hc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hc.springboot.mapper")
@SpringBootApplication
public class SpringbootSupermarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSupermarketApplication.class, args);
    }

}
