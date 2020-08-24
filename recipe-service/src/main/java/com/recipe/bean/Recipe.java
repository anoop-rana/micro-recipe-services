package com.recipe.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Recipe")
@Data
@NoArgsConstructor
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rid")
	private long rid;
	
	@Column(name = "recipeName")
	private String recipeName;
	
	@Lob
	@Column(name = "description")
	private String description;
	
	@Lob
	@Column(name = "imgPath")
	private String imgPath;
	
	//private Ingredient ingredient[];

	public Recipe(String recipeName, String description, String imgPath) {
		super();
		this.recipeName = recipeName;
		this.description = description;
		this.imgPath = imgPath;
	}
	
}
