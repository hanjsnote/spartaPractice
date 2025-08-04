package org.example.memo.controller;

import org.example.memo.dto.MemoRequestDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.entity.Memo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/memos")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto memoRequestDto){

        //식별자가 1씩 증가
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;

        //요청받은 데이터로 Memo 객체 생성
        Memo memo = new Memo(memoId, memoRequestDto.getTitle(), memoRequestDto.getContent());

        //Inmemory DB에 Memo 메모
        memoList.put(memoId, memo);

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MemoResponseDto>> findAllMemos(){

        List<MemoResponseDto> responseList = new ArrayList<>();

        for(Memo memo : memoList.values()){
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            responseList.add(responseDto);
        }

//        responseList = memoList.values().stream().map(MemoResponseDto::new).toList();
        return ResponseEntity.ok(responseList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id){

        Memo memo = memoList.get(id);

        if (memo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(new MemoResponseDto(memo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemoById(
            @PathVariable Long id,
            @RequestBody MemoRequestDto memoRequestDto
    ){
        Memo memo = memoList.get(id);

        if (memo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(memoRequestDto.getTitle() == null || memoRequestDto.getContent() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.update(memoRequestDto);
        return ResponseEntity.ok(new MemoResponseDto(memo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle(
            @PathVariable Long id,
            @RequestBody MemoRequestDto memoRequestDto
    ){
        Memo memo = memoList.get(id);

        if (memo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(memoRequestDto.getTitle() == null || memoRequestDto.getContent() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.updateTitle(memoRequestDto);

        return ResponseEntity.ok(new MemoResponseDto(memo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id){

        if(memoList.containsKey(id)){   //memoList에 id가 있다면
            memoList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
