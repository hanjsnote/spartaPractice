package com.example.springcallback.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean, DisposableBean {

    private String data;

    public MyBean() {
        System.out.println("Bean 생성자 호출");
        System.out.println("data = " + data);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    // InitializingBean 인터페이스의 초기화 메서드
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyBean 초기화 - afterPropertiesSet() 호출됨");
        System.out.println("data = " + data);
    }

    // DisposableBean 인터페이스의 종료 메서드
    @Override
    public void destroy() throws Exception {
        System.out.println("MyBean 종료 - destroy() 호출됨");
        data = null;
    }

    public void doSomething() {
        System.out.println("MyBean 작업 중...");
    }

}
