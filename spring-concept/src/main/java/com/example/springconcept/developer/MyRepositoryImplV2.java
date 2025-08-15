package com.example.springconcept.developer;

import com.example.springconcept.common.MyRepository;

public class MyRepositoryImplV2 implements MyRepository {
    @Override
    public void queryDatabase() {
        System.out.println("데이터베이스 쿼리 실행 V2");
    }
}
