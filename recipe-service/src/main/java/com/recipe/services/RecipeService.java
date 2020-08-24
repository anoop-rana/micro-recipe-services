package com.recipe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.bean.Recipe;
import com.recipe.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository repo;

	public List<Recipe> findAll() {
		return repo.findAll();
	}

	public Optional<Recipe> findRecipeById(long id) {
		return repo.findById(id);
	}

	public Optional<Recipe> findRecipeByName(String name) {
		return repo.findByRecipeName(name);
	}

	public Recipe createOrUpdate(Recipe recipe) {
		Optional<Recipe> oldRecipe = repo.findByRecipeName(recipe.getRecipeName());
		if (oldRecipe.isPresent()) {
			Recipe newRecipe = oldRecipe.get();
			newRecipe.setRecipeName(recipe.getRecipeName());
			newRecipe.setImgPath(recipe.getImgPath());
			newRecipe.setDescription(recipe.getDescription());
			return repo.save(newRecipe);
		} else {
			return repo.save(recipe);
		}
	}

	public void deleteRecipe(long id) {
		repo.delete(repo.findById(id).get());
	}
}
