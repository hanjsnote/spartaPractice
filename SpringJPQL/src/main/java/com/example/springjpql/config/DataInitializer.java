package com.example.springjpql.config;

import com.example.springjpql.entity.Student;
import com.example.springjpql.entity.Tutor;
import com.example.springjpql.repository.StudentRepository;
import com.example.springjpql.repository.TutorRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("dev")
public class DataInitializer {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init() {
        // Tutor 데이터 초기화
        Tutor tutor1 = new Tutor("tutor1");
        Tutor tutor2 = new Tutor("tutor2");
        Tutor tutor3 = new Tutor("tutor3");

        tutorRepository.save(tutor1);
        tutorRepository.save(tutor2);
        tutorRepository.save(tutor3);

        // Student 데이터 초기화
        for (int i = 0; i < 30; i++) {
            Student student = new Student("student" + i, 20 + i);
            // 튜터를 순차적으로 할당
            if (i % 3 == 0) {
                student.setTutor(tutor1);
            } else if (i % 3 == 1) {
                student.setTutor(tutor2);
            } else {
                student.setTutor(tutor3);
            }

            studentRepository.save(student);
        }

        log.info("===== Test Data Initialized =====");
    }

}
