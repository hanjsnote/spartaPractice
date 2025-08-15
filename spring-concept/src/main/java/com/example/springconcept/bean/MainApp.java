package com.example.springconcept.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Spring ApplicationContext 생성 및 설정 클래스(AppConfig) 등록
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 등록된 TestService 빈 가져오기
        TestService service = context.getBean(TestService.class);

        // 빈 메서드 호출
        service.doSomething();
    }
}
