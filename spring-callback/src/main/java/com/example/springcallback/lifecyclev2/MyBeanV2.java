package com.example.springcallback.lifecyclev2;

public class MyBeanV2 {

    private String data;

    public MyBeanV2() {
        System.out.println("Bean 생성자 호출");
        System.out.println("data = " + data);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void init() {
        System.out.println("MyBean 초기화 - init() 호출됨");
        System.out.println("data = " + data);
    }

    public void close() {
        System.out.println("MyBean 종료 - close() 호출됨");
        data = null;
    }

    public void doSomething() {
        System.out.println("MyBean 작업 중...");
    }

}
