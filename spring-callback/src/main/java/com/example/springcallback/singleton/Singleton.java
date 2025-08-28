package com.example.springcallback.singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Singleton {

    public static void main(String[] args) {
        // Spring 컨테이너 생성 및 설정 클래스 등록
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingletonAppConfig.class);

        // Bean 사용
        SingletonBean singletonBean = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);

        System.out.println("singletonBean = " + singletonBean);
        System.out.println("singletonBean2 = " + singletonBean2);

        singletonBean.doSomething();

        // 컨테이너 종료
        context.close();

    }

}
