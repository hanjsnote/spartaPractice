package com.example.springjpql.controller;

import com.example.springjpql.dto.TutorStudentCountDto;
import com.example.springjpql.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tutors")
public class TutorController {

    private final TutorService tutorService;

    /**
     * 튜터별 학생 수 조회 API
     * @return
     */
    @GetMapping("/student-counts")
    public ResponseEntity<List<TutorStudentCountDto>> getTutorStudentCounts() {
        List<TutorStudentCountDto> result = tutorService.getTutorStudentCounts();
        return ResponseEntity.ok(result);
    }


}
