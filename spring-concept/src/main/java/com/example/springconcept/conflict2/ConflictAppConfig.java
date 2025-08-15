package com.example.springconcept.conflict2;

import com.example.springconcept.common.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 수동으로 Bean 등록
@Configuration
public class ConflictAppConfig {

    // conflictService 이름으로 Bean 생성
    @Bean(name = "conflictService")
    MyService myService() {
        return new ConflictServiceV2();
    }
}
