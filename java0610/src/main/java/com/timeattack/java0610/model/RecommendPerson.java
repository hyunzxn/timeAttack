package com.timeattack.java0610.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RecommendPerson {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int gender; // 0이면 남자 1이면 여자

    public RecommendPerson(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }
}
