package com.example.characterwiki.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class OCCharacter {
	
	@Id
	private String id;
	
	private String name;
	
	private String emoji;
	
	private String age;
	
	private String origin;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String personality;
	
	private String height;
	
	private String relation;
	
	private String image;

}
