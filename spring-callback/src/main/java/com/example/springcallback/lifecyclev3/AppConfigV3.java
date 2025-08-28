package com.example.springcallback.lifecyclev3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigV3 {

    @Bean
    public MyBeanV3 myBeanV3() {
        MyBeanV3 myBeanV3 = new MyBeanV3();
        // 의존관계 설정
        myBeanV3.setData("Example");
        return myBeanV3;
    }

}
