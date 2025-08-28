package com.example.springcallback.prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProtoType {

    public static void main(String[] args) {
        // Spring 컨테이너 생성 및 설정 클래스 등록
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProtoTypeAppConfig.class);

        // Bean 사용
        System.out.println("protoTypeBean 조회");
        ProtoTypeBean protoTypeBean = context.getBean(ProtoTypeBean.class);
        System.out.println("protoTypeBean2 조회");
        ProtoTypeBean protoTypeBean2 = context.getBean(ProtoTypeBean.class);

        System.out.println("singletonBean = " + protoTypeBean);
        System.out.println("singletonBean2 = " + protoTypeBean2);

        protoTypeBean.doSomething();

        // 컨테이너 종료
        context.close();

    }

}
