package org.example.board.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String username;

    private final Integer age;

    public SignUpResponseDto(Long id, String username, Integer age){
        this.id = id;
        this.username = username;
        this.age = age;
    }

}
