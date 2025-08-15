package com.example.springconcept.developer;

import com.example.springconcept.common.MyRepository;
import com.example.springconcept.common.MyService;

public class MyApp {
    public static void main(String[] args) {
        MyRepository repo = new MyRepositoryImpl();

//        MyRepository repo2 = new MyRepositoryImplV2();

        MyService myService = new MyServiceImpl(repo);

//        MyService myService2 = new MyServiceImpl(repo);

        myService.doSomething();
    }

    public void run() {
    }
}
