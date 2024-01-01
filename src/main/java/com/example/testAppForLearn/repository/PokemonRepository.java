package com.example.testAppForLearn.repository;

import com.example.testAppForLearn.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
