package com.example.springcallback.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        // 의존관계 설정
        myBean.setData("Example");
        return myBean;
    }

}
