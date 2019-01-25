package com.vikram.spring5recipeapp.services;

import com.vikram.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
