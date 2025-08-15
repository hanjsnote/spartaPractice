package com.example.springconcept.conflict2;

import com.example.springconcept.common.MyService;
import org.springframework.stereotype.Component;

// conflictService 이름으로 Bean 생성
@Component
public class ConflictService implements MyService {
    @Override
    public void doSomething() {
        System.out.println("ConflictService 메서드 호출");
    }
}
