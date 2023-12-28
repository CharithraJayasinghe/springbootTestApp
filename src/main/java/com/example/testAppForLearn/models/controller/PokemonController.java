package com.example.testAppForLearn.models.controller;

import com.example.testAppForLearn.models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1,"Squirrel", "Water"  ));
        pokemons.add(new Pokemon(2,"Pikachu", "Electric"  ));
        pokemons.add(new Pokemon(3,"Charmander", "Fire"  ));
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon pokemonDetails(@PathVariable int id){
        return new Pokemon(id, "Squirrel", "water");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int pokemonId){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return ResponseEntity.ok(pokemon);
    }


}
