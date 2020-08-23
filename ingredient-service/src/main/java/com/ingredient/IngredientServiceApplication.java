package com.ingredient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ingredient.bean.Ingredient;
import com.ingredient.repository.IngredientRepository;

@EnableEurekaClient
@SpringBootApplication
public class IngredientServiceApplication implements CommandLineRunner{

	@Autowired
	IngredientRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(IngredientServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(
				new Ingredient("Apple", 10),
				new Ingredient("Banana", 12),
				new Ingredient("Mango", 18),
				new Ingredient("Cherry", 4),
				new Ingredient("Meat", 4),
				new Ingredient("Ice-Cream", 10),
				new Ingredient("Orange", 28),
				new Ingredient("Sugar-cane", 10),
				new Ingredient("Rice", 10),
				new Ingredient("Pasta", 10)));
		
	}

}
