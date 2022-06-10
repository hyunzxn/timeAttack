package com.timeattack.java0610.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecomendPersonRepository extends JpaRepository<RecommendPerson, Long> {
    List<RecommendPerson> findByGender();
}
