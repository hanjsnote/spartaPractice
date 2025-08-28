package com.example.springcallback.lifecyclev3;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MyBeanV3 {

    private String data;

    public MyBeanV3() {
        System.out.println("Bean 생성자 호출");
        System.out.println("data = " + data);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    // 초기화 메서드
    @PostConstruct
    public void init() {
        System.out.println("MyBean 초기화 - init() 호출됨");
        System.out.println("data = " + data);
    }

    // 소멸 메서드
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("MyBean 종료 - destroy() 호출됨");
        data = null;
    }

    public void doSomething() {
        System.out.println("MyBean 작업 중...");
    }

}
