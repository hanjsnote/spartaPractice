package com.example.springcallback.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProtoTypeAppConfig {

    @Scope("prototype")
    @Bean
    public ProtoTypeBean protoTypeBean() {
        ProtoTypeBean protoTypeBean = new ProtoTypeBean();
        return protoTypeBean;
    }

}
