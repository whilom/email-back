package com.example.emailback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.example.emailback.mapper")
public class EmailDemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(EmailDemoApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(EmailDemoApplication.class, args);
        System.out.println(" ===项目启动成功===");
    }

}
