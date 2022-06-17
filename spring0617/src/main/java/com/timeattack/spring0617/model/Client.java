package com.timeattack.spring0617.model;

import com.timeattack.spring0617.dto.ClientRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Client extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private String email;

    public Client(ClientRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.email = requestDto.getEmail();
        this.gender = requestDto.getGender();
    }

    public void update(ClientRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }
}

