package com.example.springconcept.ioc;

import com.example.springconcept.common.MyRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MyIocRepository implements MyRepository {

    @Override
    public void queryDatabase() {
        // 데이터베이스와 상호작용
        System.out.println("IOC 데이터베이스 쿼리 실행");
    }
}
