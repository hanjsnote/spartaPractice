package com.example.globalexceptionhandler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NonExceptionHandlerController {

    @RequestMapping("/v4/exception")
    public void illegalArgumentException() {

        throw new IllegalArgumentException("IllegalArgumentException 발생");

    }

}
