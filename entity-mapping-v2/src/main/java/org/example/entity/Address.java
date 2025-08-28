package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 읽기 전용
    @OneToOne(mappedBy = "address")
    private Tutor tutor;

}
