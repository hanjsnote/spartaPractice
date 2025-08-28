package com.example.springjpql.controller;

import com.example.springjpql.dto.StudentDto;
import com.example.springjpql.dto.StudentTutorDto;
import com.example.springjpql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    /**
     * 학생 검색 API
     * @param keyword 이름에 포함한 키워드
     * @param minAge 최소 나이
     * @param maxAge 최대 나이
     * @return {@link StudentDto}
     */
    @GetMapping("/search")
    public List<StudentDto> searchStudents(
            @RequestParam String keyword,
            @RequestParam int minAge,
            @RequestParam int maxAge
    ) {
        return studentService.searchStudents(keyword, minAge, maxAge);
    }

    /**
     * 자신과 연관된 튜터 조회 API
     * N + 1 fetch join
     * @return
     */
    @GetMapping("/with-tutors")
    public List<StudentTutorDto> getStudentsWithTutors() {
        return studentService.getStudentsWithTutors();
    }

}
