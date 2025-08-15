package com.example.springconcept.conflict2;

import com.example.springconcept.common.MyService;

public class ConflictServiceV2 implements MyService {
    @Override
    public void doSomething() {
        System.out.println("ConflictServiceV2 메서드 호출");
    }
}
