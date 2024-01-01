package com.example.testAppForLearn.controller;
import com.example.testAppForLearn.dto.PokemonDto;
import com.example.testAppForLearn.models.Pokemon;
import com.example.testAppForLearn.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    Logger logger = Logger.getLogger(getClass().getName());
    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonDto>> getPokemons(){
        return new ResponseEntity<>(pokemonService.getAllPokemon(), HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon pokemonDetails(@PathVariable int id){
        return new Pokemon(id, "Squirrel", "water");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int pokemonId){
        logger.info(pokemon.getName());
        logger.info(pokemon.getType());
        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId) {
        return ResponseEntity.ok( "Pokemon deleted successfully");
    }



}
