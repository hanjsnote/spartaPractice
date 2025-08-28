package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Company company;

    @OneToOne
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "tutor_language",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();

//    @OneToMany(mappedBy = "tutor")
//    private List<TutorLanguage> tutorLanguages = new ArrayList<>();

    public Tutor() {
    }

    public Tutor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
