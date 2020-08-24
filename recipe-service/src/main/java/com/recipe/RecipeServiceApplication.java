package com.recipe;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.recipe.bean.Recipe;
import com.recipe.bean.RecipeData;
import com.recipe.repository.RecipeRepository;

@EnableEurekaClient
@SpringBootApplication
public class RecipeServiceApplication implements CommandLineRunner{

	@Autowired
	RecipeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(RecipeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(
				new Recipe("Pasta", RecipeData.Pasta_Desc, RecipeData.Pasta),
				new Recipe("Chicken", RecipeData.Chicken_Wings_Desc, RecipeData.Chicken_Wings),
				new Recipe("Raspberries", RecipeData.Raspberries_Desc, RecipeData.Raspberries)
				));
	}

}
