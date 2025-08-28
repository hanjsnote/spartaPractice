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

    private Integer age;

    @Embedded
    private Period period;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Company company;

    @OneToOne
    @JoinColumn(name = "address_id", unique = true)
    private Address address;


    @OneToMany(mappedBy = "tutor")
    private List<TutorLanguage> tutorLanguages = new ArrayList<>();

    public Tutor() {
    }

    public Tutor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
