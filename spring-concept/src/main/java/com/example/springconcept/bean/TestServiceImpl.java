package com.example.springconcept.bean;


public class TestServiceImpl implements TestService {
    @Override
    public void doSomething() {
        System.out.println("Test Service 메서드 호출");
    }
}
