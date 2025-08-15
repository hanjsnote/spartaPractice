package com.example.springconcept.conflict2;

import com.example.springconcept.common.MyService;
import com.example.springconcept.conflict.ConflictApp;
import com.example.springconcept.conflict.ConflictService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.springconcept.conflict2")
public class ConflictApp2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConflictApp2.class);

        // Service 빈을 가져와서 실행
        MyService service = context.getBean(MyService.class);

        service.doSomething();
    }
}
