package com.example.springjpql.repository;

import com.example.springjpql.dto.StudentDto;
import com.example.springjpql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new com.example.springjpql.dto.StudentDto(s.name, s.age) " +
            "from Student s where s.name like %:keyword% " +
            "and s.age >= :minAge and s.age <= :maxAge")
    List<StudentDto> findByNameContainingAndAgeBetween(
            @Param("keyword") String keyword,
            @Param("minAge") int minAge,
            @Param("maxAge") int maxAge
    );

    @Query("select s from Student s join fetch s.tutor")
    List<Student> findStudentsWithTutor();

}
