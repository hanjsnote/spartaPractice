package com.example.springcallback.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonAppConfig {

    @Scope("singleton")
    @Bean
    public SingletonBean singletonBean() {
        SingletonBean singletonBean = new SingletonBean();
        return singletonBean;
    }

}
