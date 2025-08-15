package com.example.springconcept.conflict;

import org.springframework.stereotype.Component;

// Bean의 이름을 service로 설정
@Component
public class ConflictServiceV1 implements ConflictService {
    @Override
    public void test() {
        System.out.println("Conflict V1");
    }
}
