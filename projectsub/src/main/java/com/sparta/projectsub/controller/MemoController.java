package com.sparta.projectsub.controller;

import com.sparta.projectsub.domain.Memo;
import com.sparta.projectsub.domain.MemoRepository;
import com.sparta.projectsub.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;  //생성 조회 삭제를 위해서
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {  //@requestbody는 요청하면서 날아오는 정보를 request에 넣어주기 위해 썼음
        Memo memo = new Memo(requestDto);  // Memo에 requestDto의 값을 넣어줌 Memo class에 생성자가 있어서 가능
        return memoRepository.save(memo);  // 바뀐 메모를 repository에 저장
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {

        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

}
