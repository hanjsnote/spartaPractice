package com.example.springcallback.singleton;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonBean {

    public SingletonBean() {
        System.out.println("Bean 생성자 호출");
    }

    // 초기화 메서드
    @PostConstruct
    public void init() {
        System.out.println("init() 호출");
    }

    // 소멸 메서드
    @PreDestroy
    public void destroy() {
        System.out.println("destroy() 호출");
    }

    public void doSomething() {
        System.out.println("SingletonBean 작업 중...");
    }

}
