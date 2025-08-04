package org.example.memo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.memo.dto.MemoRequestDto;
import org.example.memo.dto.MemoResponseDto;

@Getter
@AllArgsConstructor
public class Memo {

    private Long id;
    private String title;
    private String content;

    public void update(MemoRequestDto memoRequestDto){
        this.title = memoRequestDto.getTitle();
        this.content = memoRequestDto.getContent();
    }

    public void updateTitle(MemoRequestDto memoRequestDto){
        this.title = memoRequestDto.getTitle();
    }

}
