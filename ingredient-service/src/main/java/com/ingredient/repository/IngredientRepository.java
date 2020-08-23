package com.ingredient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingredient.bean.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
	
	public Optional<Ingredient> findByName(String name);

}
