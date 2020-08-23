package com.ingredient.controller;

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

import com.ingredient.bean.Ingredient;
import com.ingredient.services.IngredientService;

@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;

	@GetMapping
	public ResponseEntity<List<Ingredient>> findAllIngredient() {
		List<Ingredient> list = ingredientService.findAll();
		return new ResponseEntity<List<Ingredient>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Optional<Ingredient> ingredient = ingredientService.findIngredientById(id);
		return validateIngredient(ingredient);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Object> findByName(@PathVariable String name) {
		Optional<Ingredient> ingredient = ingredientService.findIngredientByName(name);
		return validateIngredient(ingredient);
	}

	@PostMapping
	public ResponseEntity<Ingredient> createOrUpdate(@RequestBody Ingredient ingredient) {
		Ingredient updated = ingredientService.createOrUpdate(ingredient);
		return new ResponseEntity<Ingredient>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		Optional<Ingredient> ingredient = ingredientService.findIngredientById(id);
		if (ingredient.isPresent()) {
			ingredientService.deleteIngredient(id);
			return new ResponseEntity<Object>("Deleted", new HttpHeaders(), HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<Object>("Not Found", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	private ResponseEntity<Object> validateIngredient(Optional<Ingredient> ingredient) {
		if (ingredient.isPresent())
			return new ResponseEntity<Object>(ingredient.get(), new HttpHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Ingredient Not Found", new HttpHeaders(), HttpStatus.OK);
	}
}
