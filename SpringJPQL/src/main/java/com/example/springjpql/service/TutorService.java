package com.example.springjpql.service;

import com.example.springjpql.dto.TutorStudentCountDto;
import com.example.springjpql.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;


    public List<TutorStudentCountDto> getTutorStudentCounts() {
        return tutorRepository.findTutorStudentCounts();
    }


}
