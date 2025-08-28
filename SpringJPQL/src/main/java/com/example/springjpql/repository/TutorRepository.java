package com.example.springjpql.repository;

import com.example.springjpql.dto.TutorStudentCountDto;
import com.example.springjpql.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    @Query("select new com.example.springjpql.dto.TutorStudentCountDto(t.name, count(s)) " +
            "from Tutor t join t.students s group by t.name")
    List<TutorStudentCountDto> findTutorStudentCounts();



}
