package com.example.springjpql.dto;

import lombok.Getter;

/**
 * 학생 ResponseDto
 */
@Getter
public class StudentDto {

    private final String name;

    private final Integer age;

    public StudentDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
