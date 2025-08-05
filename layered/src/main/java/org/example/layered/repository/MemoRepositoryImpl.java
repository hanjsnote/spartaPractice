package org.example.layered.repository;

import org.example.layered.dto.MemoResponseDto;
import org.example.layered.entity.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoRepositoryImpl implements MemoRepository{

    private final Map<Long, Memo> memoList = new HashMap<>();

    @Override
    public Memo saveMemo(Memo memo) {

        // memo 식별자 자동 생성
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        memo.setId(memoId);

        memoList.put(memoId, memo);

        return memo;
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {

        //리스트 토기화
        List<MemoResponseDto> allMemos = new ArrayList<>();

        for(Memo memo : memoList.values()){
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            allMemos.add(responseDto);
        }

        return allMemos;
    }

    @Override
    public Memo findMemoById(Long id) {
        return memoList.get(id);
    }

    @Override
    public void deleteMemo(Long id) {
        memoList.remove(id);
    }
}
