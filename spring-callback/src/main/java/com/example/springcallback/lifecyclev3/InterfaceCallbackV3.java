package com.example.springcallback.lifecyclev3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InterfaceCallbackV3 {

    public static void main(String[] args) {
        // Spring 컨테이너 생성 및 설정 클래스 등록
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigV3.class);

        // Bean 사용
        MyBeanV3 myBeanV3 = context.getBean(MyBeanV3.class);
        myBeanV3.doSomething();

        // Bean 소멸 전 필드
        System.out.println(myBeanV3.getData());

        // 컨테이너 종료 (destroy 호출)
        context.close();

        // Bean 소멸 후 필드
        System.out.println(myBeanV3.getData());
    }

}
