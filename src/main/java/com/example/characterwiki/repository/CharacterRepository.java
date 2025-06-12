package com.example.characterwiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.characterwiki.Entity.OCCharacter;

public interface CharacterRepository extends JpaRepository<OCCharacter, String>{

}
