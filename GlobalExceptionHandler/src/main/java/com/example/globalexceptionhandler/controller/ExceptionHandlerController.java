package com.example.globalexceptionhandler.controller;

import com.example.globalexceptionhandler.service.ExceptionHandlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ExceptionHandlerController {

    private final ExceptionHandlerService exceptionHandlerService;

    @RequestMapping("/v1/exception")
    public void illegalArgumentException() {

        throw new IllegalArgumentException("IllegalArgumentException 발생");

    }

    @RequestMapping("/v2/exception")
    public void nullPointerException() {

        throw new NullPointerException("NPE 발생");
    }

    @RequestMapping("/v3/exception")
    public void serviceLayerException() {

        exceptionHandlerService.throwNewIllegalArgumentException();
    }

    // IllegalArgumentException을 처리하는 메서드
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {

        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

}