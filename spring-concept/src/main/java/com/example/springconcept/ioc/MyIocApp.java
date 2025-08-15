package com.example.springconcept.ioc;

import com.example.springconcept.common.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.springconcept.ioc")
public class MyIocApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyIocApp.class);

        // Service 빈을 가져와서 실행
        MyService service = context.getBean(MyService.class);
        service.doSomething();
    }
}
