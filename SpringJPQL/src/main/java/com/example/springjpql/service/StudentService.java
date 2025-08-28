package com.example.springjpql.service;

import com.example.springjpql.dto.StudentDto;
import com.example.springjpql.dto.StudentTutorDto;
import com.example.springjpql.entity.Student;
import com.example.springjpql.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDto> searchStudents(String keyword, int minAge, int maxAge) {
        return studentRepository.findByNameContainingAndAgeBetween(keyword, minAge, maxAge);
    }

    /**
     * DTO 형태로 반환 가능
     * @return
     */
    public List<StudentTutorDto> getStudentsWithTutors() {
        List<Student> students = studentRepository.findStudentsWithTutor();

        return students.stream()
                .map(student -> new StudentTutorDto(
                        student.getName(),
                        student.getAge(),
                        student.getTutor().getName()))
                .collect(Collectors.toList());
    }

}
