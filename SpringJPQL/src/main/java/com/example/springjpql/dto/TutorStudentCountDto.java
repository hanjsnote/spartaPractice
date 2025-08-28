package com.example.springjpql.dto;

import lombok.Getter;

/**
 * 튜터별 학생 수
 */
@Getter
public class TutorStudentCountDto {

    private final String name;

    private final Long count;

    public TutorStudentCountDto(String name, Long count) {
        this.name = name;
        this.count = count;
    }

}
