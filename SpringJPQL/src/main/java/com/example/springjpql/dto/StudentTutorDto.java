package com.example.springjpql.dto;

import lombok.Getter;

@Getter
public class StudentTutorDto {

    private final String name;

    private final Integer age;

    private final String tutorName;

    public StudentTutorDto(java.lang.String name, Integer age, String tutorName) {
        this.name = name;
        this.age = age;
        this.tutorName = tutorName;
    }
}
