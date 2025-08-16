package org.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member") //지정 안해도 기본적으로 엔티티 클래스 이름 member table이 생성됨
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer age;

    public Member(String username, String password, Integer age){
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public void updatePassword(String password){
        this.password = password;
    }

}

