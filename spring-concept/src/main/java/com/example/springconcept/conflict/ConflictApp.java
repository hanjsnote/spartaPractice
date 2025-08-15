package com.example.springconcept.conflict;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.springconcept.conflict")
public class ConflictApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConflictApp.class);

        // Service 빈을 가져와서 실행
        ConflictService service = context.getBean(ConflictService.class);

        service.test();
    }
}
