package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tutor_language")
public class TutorLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    private Integer level;

    private String license;

}
