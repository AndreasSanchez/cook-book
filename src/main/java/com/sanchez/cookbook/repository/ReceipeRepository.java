package com.sanchez.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanchez.cookbook.entity.Receipe;

public interface ReceipeRepository extends JpaRepository<Receipe, Integer> {

}
