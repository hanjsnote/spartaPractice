package com.example.springcallback.lifecyclev2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigV2 {

    @Bean(initMethod = "init", destroyMethod = "close")
    public MyBeanV2 myBeanV2() {
        MyBeanV2 myBeanV2 = new MyBeanV2();
        // 의존관계 설정
        myBeanV2.setData("Example");
        return myBeanV2;
    }

}
