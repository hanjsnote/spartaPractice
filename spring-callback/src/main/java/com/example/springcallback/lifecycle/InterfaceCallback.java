package com.example.springcallback.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InterfaceCallback {

    public static void main(String[] args) {
        // Spring 컨테이너 생성 및 설정 클래스 등록
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Bean 사용
        MyBean myBean = context.getBean(MyBean.class);
        myBean.doSomething();

        // Bean 소멸 전 필드
        System.out.println(myBean.getData());

        // 컨테이너 종료 (DisposableBean 호출됨)
        context.close();

        // Bean 소멸 후 필드
        System.out.println(myBean.getData());
    }

}
