package com.example.globalexceptionhandler.service;

import org.springframework.stereotype.Service;

@Service
public class ExceptionHandlerService {

    public void throwNewIllegalArgumentException() {
        throw new IllegalArgumentException("ServiceLayer Exception");
    }

}
