package com.ingredient.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingredient.bean.Ingredient;
import com.ingredient.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	IngredientRepository repo;

	public List<Ingredient> findAll() {
		return repo.findAll();
	}

	public Optional<Ingredient> findIngredientById(long id) {
		return repo.findById(id);
	}

	public Optional<Ingredient> findIngredientByName(String name) {
		return repo.findByName(name);
	}

	public Ingredient createOrUpdate(Ingredient ingredient) {
		Optional<Ingredient> ingred = repo.findByName(ingredient.getName());
		if (ingred.isPresent()) {
			Ingredient ingred2 = ingred.get();
			ingred2.setName(ingredient.getName());
			ingred2.setAmount(ingredient.getAmount());
			return repo.save(ingred2);
		} else {
			return repo.save(ingredient);
		}
	}

	public void deleteIngredient(long id) {
		repo.delete(repo.findById(id).get());
	}

}
