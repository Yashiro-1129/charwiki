package com.example.characterwiki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.characterwiki.Entity.OCCharacter;
import com.example.characterwiki.repository.CharacterRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {
	
	@Autowired
	private CharacterRepository repo;
	
	@GetMapping
	public List<OCCharacter> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public OCCharacter getById(@PathVariable String id) {
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping
	public OCCharacter create(@RequestBody OCCharacter occharacter) {
		return repo.save(occharacter);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OCCharacter> updateCharacter(@PathVariable String id,@RequestBody OCCharacter updatedCharacter){
		return repo.findById(id)
				.map(character -> {
					character.setId(updatedCharacter.getId());
					character.setName(updatedCharacter.getName());
					character.setEmoji(updatedCharacter.getEmoji());
					character.setAge(updatedCharacter.getAge());
					character.setOrigin(updatedCharacter.getOrigin());
					character.setPersonality(updatedCharacter.getPersonality());
					character.setHeight(updatedCharacter.getHeight());
					character.setRelation(updatedCharacter.getRelation());
					character.setImage(updatedCharacter.getImage());
					
					OCCharacter saved = repo.save(character);
					return ResponseEntity.ok(saved);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
