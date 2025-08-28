package com.example.springcallback.lifecyclev2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InterfaceCallbackV2 {

    public static void main(String[] args) {
        // Spring 컨테이너 생성 및 설정 클래스 등록
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigV2.class);

        // Bean 사용
        MyBeanV2 myBeanV2 = context.getBean(MyBeanV2.class);
        myBeanV2.doSomething();

        // Bean 소멸 전 필드
        System.out.println(myBeanV2.getData());

        // 컨테이너 종료 (destroy 호출)
        context.close();

        // Bean 소멸 후 필드
        System.out.println(myBeanV2.getData());
    }

}
