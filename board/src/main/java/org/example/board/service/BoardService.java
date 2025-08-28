package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.dto.BoardResponseDto;
import org.example.board.dto.BoardWithAgeResponseDto;
import org.example.board.dto.CreateBoardRequestDto;
import org.example.board.entity.Board;
import org.example.board.entity.Member;
import org.example.board.repository.BoardRepository;
import org.example.board.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

//    public BoardResponseDto save(String title, String contents, String username) {
//
//        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);
//
//        Board board = new Board(title, contents);
//        board.setMember(findMember);
//
//        boardRepository.save(board);
//
//        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
//    }

    //게시글 생성
    public BoardResponseDto save(CreateBoardRequestDto requestDto) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(requestDto.getUsername());

        Board board = new Board(requestDto.getTitle(), requestDto.getContents());
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }

    //게시글 전체 조회
    public List<BoardResponseDto> findAll() {

        return boardRepository.findAll().stream().map(BoardResponseDto::toDto).toList();
    }

    //특정 게시글 조회
    public BoardWithAgeResponseDto findById(Long id){

        Board findBoard = boardRepository.findByIdOrElseThrow(id);
        Member writer = findBoard.getMember();

        return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
    }


    public void delete(Long id) {

        Board findBoard = boardRepository.findByIdOrElseThrow(id);

        boardRepository.delete(findBoard);
    }
}
