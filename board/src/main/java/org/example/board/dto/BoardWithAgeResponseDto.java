package org.example.board.dto;

import lombok.Getter;

//요구조건 : 응답에 작성자 나이를 포함한다.
@Getter
public class BoardWithAgeResponseDto {

    private final String title;

    private final String content;

    private final Integer age;

    public BoardWithAgeResponseDto (String title, String content,  Integer age){
        this.title = title;
        this.content = content;
        this.age = age;
    }

}
