package com.example.springconcept.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 수동으로 빈 등록
@Configuration
public class AppConfig {

    // TestService 타입의 Spring Bean 등록
    @Bean
    public TestService testService() {
        // TestServiceImpl을 Bean으로 등록
        return new TestServiceImpl();
    }

}
