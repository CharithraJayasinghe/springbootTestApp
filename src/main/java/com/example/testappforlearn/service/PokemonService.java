package com.example.testappforlearn.service;

import com.example.testappforlearn.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    List<PokemonDto> getAllPokemon();
    PokemonDto getPokemonById(int Id);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemon(int id);
}
