package com.example.uerinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.userinfo.mapper")
public class UerInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UerInfoApplication.class, args);
    }

}
