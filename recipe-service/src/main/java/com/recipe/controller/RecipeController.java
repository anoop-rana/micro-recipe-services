package com.recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.bean.Recipe;
import com.recipe.services.RecipeService;

@RestController
@RequestMapping("/item")
public class RecipeController {

	@Autowired
	RecipeService service;
	
	@GetMapping
	public ResponseEntity<List<Recipe>> findAllIngredient() {
		List<Recipe> list = service.findAll();
		return new ResponseEntity<List<Recipe>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Optional<Recipe> recipe = service.findRecipeById(id);
		return validateRecipe(recipe);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Object> findByName(@PathVariable String name) {
		Optional<Recipe> recipe = service.findRecipeByName(name);
		return validateRecipe(recipe);
	}

	@PostMapping
	public ResponseEntity<Recipe> createOrUpdate(@RequestBody Recipe recipe) {
		Recipe updated = service.createOrUpdate(recipe);
		return new ResponseEntity<Recipe>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		Optional<Recipe> recipe = service.findRecipeById(id);
		if (recipe.isPresent()) {
			service.deleteRecipe(id);
			return new ResponseEntity<Object>("Deleted", new HttpHeaders(), HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<Object>("Not Found", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	private ResponseEntity<Object> validateRecipe(Optional<Recipe> recipe) {
		if (recipe.isPresent())
			return new ResponseEntity<Object>(recipe.get(), new HttpHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Recipe Not Found", new HttpHeaders(), HttpStatus.OK);
	}
}
