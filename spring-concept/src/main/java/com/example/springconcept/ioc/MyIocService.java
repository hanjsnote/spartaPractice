package com.example.springconcept.ioc;

import com.example.springconcept.common.MyRepository;
import com.example.springconcept.common.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyIocService implements MyService {
    private final MyRepository myRepository;

    // 생성자 주입(DI 적용)
    @Autowired
    public MyIocService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @Override
    public void doSomething() {
        System.out.println("IOC 서비스 작업 실행");
        myRepository.queryDatabase();
    }
}
