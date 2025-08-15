package com.example.springconcept.developer;

import com.example.springconcept.common.MyRepository;
import com.example.springconcept.common.MyService;

public class MyServiceImpl implements MyService {

    private MyRepository myRepository;

    // 의존성 주입
    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @Override
    public void doSomething() {
        System.out.println("서비스 작업 실행");
        myRepository.queryDatabase();
    }
}
