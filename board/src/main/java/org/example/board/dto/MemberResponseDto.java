package org.example.board.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final String userame;

    private final Integer age;

    public MemberResponseDto(String userame, Integer age){
        this.userame = userame;
        this.age = age;
    }
}
