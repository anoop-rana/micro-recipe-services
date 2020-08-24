package com.recipe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.bean.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	public Optional<Recipe> findByRecipeName(String name);
}
