package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.dto.BoardResponseDto;
import org.example.board.dto.BoardWithAgeResponseDto;
import org.example.board.dto.CreateBoardRequestDto;
import org.example.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //게시글 생성
//    @PostMapping
//    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {
//
//        BoardResponseDto boardResponseDto = boardService.save(
//                        requestDto.getTitle(),
//                        requestDto.getContents(),
//                        requestDto.getUsername()
//                );
//
//        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
//    }

    //게시글 생성
    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {

        BoardResponseDto boardResponseDto = boardService.save(requestDto);

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    //게시글 전체 조회
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll(){

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    //특정 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardWithAgeResponseDto> findById(@PathVariable Long id){

        BoardWithAgeResponseDto boardWithAgeResponseDto = boardService.findById(id);

        return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
    }

    //특정 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        boardService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
